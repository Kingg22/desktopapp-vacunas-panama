package logic.validations;

import logic.connexions.DatabaseOperaciones;
import logic.connexions.Resultados;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InicioSesion {
    private static final HashMap<String, List<Usuario>> usuariosRole = new HashMap<>();
    private static final DatabaseOperaciones db = new DatabaseOperaciones();

    public InicioSesion() {
        inicializarRoles();
        inicializarUsuariosLocales();
        System.out.println();
        sincronizarUsuariosBD();
        System.out.println();
    }

    private void inicializarRoles() {
        String[] roles = { "Paciente", "Doctor - Enfermera", "Fabricante", "Administrativo", "Autoridad",
                "Administrador" };
        for (String role : roles) {
            usuariosRole.put(role, new ArrayList<>());
        }
    }

    private void inicializarUsuariosLocales() {
        usuariosRole.get("Administrador").add(new Usuario("8-1024-1653", "admin", Usuario.hashPassword("admin1234"),
                Timestamp.valueOf("2005-07-22 00:00:00")));
        System.out.println("Administrador insertado local. 8-1024-1653 admin");
    }

    private void sincronizarUsuariosBD() {
        try {
            System.out.println("Verificar los usuarios de la base de datos.");
            Resultados result = db.showUsuarios("admin", "admin1234", "Administrador");
            Object[][] da = result.getDatos();
            if (da.length != 0) {
                System.out
                        .println("Se han encontrado usuarios en la base de datos! Count: " + result.getDatos().length);
                System.out.println();
                sincronizarUsuarios(result);
            } else {
                System.out.println("NO se encontraron usuarios en la base de datos.");
            }
            System.out.println();
            insertarUsuariosPredeterminados();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un fatal error. Cerrar el programa y contacte a soporte",
                    "ERROR InicioSesion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sincronizarUsuarios(Resultados result) throws SQLException {
        Object[][] da = result.getDatos();
        for (Object[] dato : da) {
            if (dato[4].equals("5")) {
                continue;
            }
            String cedula = (String) dato[1];
            String rol = DatabaseOperaciones.getTipo((Integer) dato[4]);
            Usuario userLocal = buscar(cedula, rol);
            if (userLocal == null) {
                usuariosRole.get(rol).add(new Usuario(cedula, (String) dato[2], (String) dato[3], (Timestamp) dato[5]));
                System.out.println("Se ha insertado USUARIO local encontrado en la base de datos. CIP:" + cedula
                        + " user: " + dato[2] + " Rol: " + rol);
            } else {
                actualizarUsuarioLocal(userLocal, dato, rol);
            }
        }
    }

    private void actualizarUsuarioLocal(Usuario userLocal, Object[] dato, String rol) {
        boolean needsUpdate = !userLocal.getUsuario().equals(dato[2]) ||
                !userLocal.getFechaNacimiento().equals(dato[5]);

        if (needsUpdate) {
            boolean statusBDLocal = modificarUsuario((String) dato[1], (String) dato[2], (String) dato[3],
                    (Timestamp) dato[5], rol);
            if (statusBDLocal) {
                System.out.println("Se ha actualizado localmente un usuario encontrado en la base de datos. CIP:"
                        + dato[1] + " user: " + dato[2] + " Rol: " + rol);
            }
        }
    }

    private void insertarUsuariosPredeterminados() throws SQLException, ClassNotFoundException {
        Usuario adminLocal = buscar("8-1024-1653", "Administrador");
        if (adminLocal != null) {
            int adminCount = db.createAdminBD(adminLocal.getCedula(), adminLocal.getUsuario(),
                    adminLocal.getPasswordHash(), adminLocal.getFechaNacimiento());
            if (adminCount > 0) {
                System.out.println("Se ha insertado ADMIN a base de datos. Count: " + adminCount);
            }
        }
        String[] roles = { "Fabricante", "Doctor - Enfermera", "Autoridad", "Administrativo", "Paciente" };
        Object[] datos = { "Rey", "Acosta", "8-1024-1653", "2005-07-22 00:00:00", 'M', null, null, null, null, "admin",
                "admin1234" };
        for (String rol : roles) {
            if (rol.equals("Paciente")) {
                datos[2] = "2-4558-5479";
            }
            if (buscar((String) datos[2], rol) == null) {
                insertar((String) datos[0], (String) datos[1], (String) datos[2], Timestamp.valueOf((String) datos[3]),
                        (char) datos[4], (String) datos[5], (String) datos[6], (String) datos[7], (String) datos[8],
                        (String) datos[9], (String) datos[10], rol);
            } else {
                modificarObligatorias((String) datos[2], (String) datos[0], (String) datos[1],
                        Timestamp.valueOf((String) datos[3]), (String) datos[9], (String) datos[10], rol);
                System.out.println("Se ha actualizado USUARIO LOCAL de usuarios predeterminados.");
            }
        }
    }

    public static boolean autentificar(String usuario, String password, String rol) {
        Usuario consultado = obtener(usuario, rol);
        if (consultado != null) {
            return consultado.checkPassword(password);
        } else {
            return false;
        }
    }

    public static Usuario obtener(String usuario, String rol) {
        List<Usuario> usuarios = usuariosRole.get(rol);
        if (usuarios != null) {
            for (Usuario u : usuarios) {
                if (u.getUsuario().equals(usuario)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Usuario buscar(String cedula, String rol) {
        List<Usuario> usuarios = usuariosRole.get(rol);
        if (usuarios != null) {
            for (Usuario u : usuarios) {
                if (u.getCedula().equals(cedula)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static boolean restaurar(String cedula, String fechaNacimiento, String rol) {
        Timestamp fechaNacimientoNueva = Timestamp.valueOf(LocalDate.parse(fechaNacimiento).atStartOfDay());
        Usuario encontrado = buscar(cedula, rol);
        if (encontrado != null) {
            return encontrado.getFechaNacimiento().equals(fechaNacimientoNueva);
        } else {
            return false;
        }
    }

    public static boolean insertar(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, char sexo,
            String distrito, String direccion, String correo, String telefono, String usuario, String password,
            String rol) throws SQLException, ClassNotFoundException {
        if (rol.equals("Paciente")) {
            // Verificar si el paciente ya existe en la base de datos
            Resultados result = db.searchPaciente("admin", "admin1234", "Administrador", cedula, null, null);
            Object[][] datos = result.getDatos();
            if (datos.length != 0) {
                boolean needsUpdate = !datos[0][1].equals(nombre) ||
                        !datos[0][2].equals(apellido) ||
                        !fechaNacimiento.equals(Timestamp.valueOf(datos[0][3].toString())) ||
                        datos[0][5].toString().charAt(0) != sexo ||
                        !((datos[0][6] != null && datos[0][6].equals(telefono))
                                || (datos[0][6] == null && telefono == null))
                        ||
                        !((datos[0][7] != null && datos[0][7].equals(correo))
                                || (datos[0][7] == null && correo == null))
                        ||
                        !(((int) datos[0][8] != 0 && datos[0][8].equals(direccion))
                                || ((int) datos[0][8] == 0 && direccion == null));

                // Si se necesita una actualización, llama a ManipularPaciente
                if (needsUpdate) {
                    try {
                        int actualizado = db.manipulatePaciente("admin", "admin1234", "Administrador", cedula, nombre,
                                apellido, fechaNacimiento, sexo, telefono, correo, direccion, distrito);
                        if (actualizado > 0) {
                            System.out.println("Actualizado PACIENTE en la base de datos." + usuario + " " + cedula);
                        } else {
                            System.err
                                    .println("Se necesita actualizar al PACIENTE en la base de datos y no se ha podido "
                                            + usuario + " " + cedula);
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR al actualizar el PACIENTE en la base de datos. " + usuario + " "
                                + cedula + "\n" + e);
                        return false;
                    }
                } else {
                    System.out.println("No actualizar PACIENTE en la base de datos. " + usuario + " " + cedula);
                }
            } else {
                // Si el paciente no existe, insertarlo
                try {
                    int insertadoBD = db.manipulatePaciente("admin", "admin1234", "Administrador", cedula, nombre,
                            apellido, fechaNacimiento, sexo, telefono, correo, direccion, distrito);
                    if (insertadoBD > 0) {
                        System.out.println("Insertado PACIENTE en la base de datos. " + usuario + " " + cedula);
                    } else {
                        System.err.println("Se necesita insertar al PACIENTE en la base de datos y no se ha podido. "
                                + usuario + " " + cedula);
                    }
                } catch (Exception e) {
                    System.err.println(
                            "ERROR al insertar el PACIENTE en la base de datos. " + usuario + " " + cedula + "\n" + e);
                    return false;
                }
            }
        }

        // Verificar si el usuario ya existe de forma local
        if (buscar(cedula, rol) == null) {
            boolean insertado = usuariosRole.get(rol).add(new Usuario(nombre, apellido, cedula, fechaNacimiento, correo,
                    telefono, direccion, distrito, usuario, password));
            // Verificar si el usuario ya existe en la base de datos
            Resultados result2 = db.searchUsuario("admin", "admin1234", "Administrador", cedula, rol);

            if (result2 != null && result2.getDatos().length != 0) {
                Object[][] datos2 = result2.getDatos();
                Timestamp fechaBD = Timestamp.valueOf(datos2[0][3].toString().replace(" ", "T"));

                boolean needsUpdate = !datos2[0][2].equals(usuario) ||
                        !Usuario.check2Password(password, datos2[0][3].toString()) ||
                        !fechaNacimiento.equals(fechaBD);

                if (needsUpdate) {
                    // Crear el usuario en la base de datos
                    try {
                        int usuarioCreado = db.manipulateUsuario("admin", "admin1234", "Administrador", cedula, usuario,
                                Usuario.hashPassword(password), rol, fechaNacimiento);
                        if (usuarioCreado > 0) {
                            System.out.println(
                                    "Actualizado USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
                        } else {
                            System.out
                                    .println("Se necesita actualizar el USUARIO en la base de datos y no se ha podido. "
                                            + usuario + " " + cedula + " " + rol);
                            return false;
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR al actualizar el USUARIO en la base de datos. " + usuario + " "
                                + cedula + " " + rol + "\n" + e);
                        return false;
                    }
                    return insertado;
                } else {
                    System.out.println(
                            "NO actualizar el USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
                }
            } else {
                // Insertar en la base de datos
                try {
                    int usuarioCreado = db.manipulateUsuario("admin", "admin1234", "Administrador", cedula, usuario,
                            Usuario.hashPassword(password), rol, fechaNacimiento);
                    if (usuarioCreado > 0) {
                        System.out.println(
                                "Insertado el USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
                    } else {
                        System.err.println("Se necesita insertar el USUARIO en la base de datos. " + usuario + " "
                                + cedula + " " + rol);
                        return false;
                    }
                } catch (Exception e) {
                    System.err.println("ERROR al insertar el USUARIO en la base de datos. " + usuario + " " + cedula
                            + " " + rol + "\n" + e);
                    return false;
                }
                return true;
            }
        } else {
            System.out.println("NO insertado USUARIO de forma local porque ya existe y no requiere actualizar. "
                    + usuario + " " + cedula + " " + rol);
        }
        return false;
    }

    public static boolean modificarCompleto(String cedula, String nombre, String apellido, Timestamp fechaNacimiento,
            String correo, String telefono, String direccion, String distrito, String usuario, String password,
            String rol) {
        Usuario user = buscar(cedula, rol);
        if (user != null) {
            user.modificarCompleto(nombre, apellido, cedula, fechaNacimiento, correo, telefono, direccion, distrito,
                    usuario, password);
            actualizarBaseDatosUsuario(cedula, usuario, password, fechaNacimiento, rol);
            return true;
        } else {
            return false;
        }
    }

    public static boolean modificarObligatorias(String cedula, String nombre, String apellido,
            Timestamp fechaNacimiento, String usuario, String password, String rol) {
        Usuario user = buscar(cedula, rol);
        if (user != null) {
            user.modificarObligatorias(nombre, apellido, cedula, fechaNacimiento, usuario, password);
            return true;
        } else {
            return false;
        }
    }

    public static boolean modificarDatos(String cedula, String nombre, String apellido, Timestamp fechaNacimiento,
            String rol) {
        Usuario usuario = buscar(cedula, rol);
        if (usuario != null) {
            usuario.modificarDatos(nombre, apellido, cedula, fechaNacimiento);
            actualizarBaseDatosUsuarioPasswordHash(cedula, usuario.getUsuario(), usuario.getPasswordHash(),
                    fechaNacimiento, rol);
            return true;
        } else {
            return false;
        }
    }

    public static boolean modificarCredenciales(String cedula, String usuarioNuevo, String passwordNuevo, String rol) {
        Usuario usuarioF = buscar(cedula, rol);
        if (usuarioF != null) {
            usuarioF.modificarCredenciales(usuarioNuevo, passwordNuevo);
            actualizarBaseDatosUsuario(cedula, usuarioNuevo, passwordNuevo, usuarioF.getFechaNacimiento(), rol);
            return true;
        } else {
            return false;
        }
    }

    private static boolean modificarUsuario(String cedula, String usuario, String passwordHash,
            Timestamp fechaNacimiento, String rol) {
        Usuario usuarioF = buscar(cedula, rol);
        if (usuarioF != null) {
            usuarioF.modificarUsuario(cedula, usuario, passwordHash, fechaNacimiento);
            actualizarBaseDatosUsuarioPasswordHash(cedula, usuario, passwordHash, fechaNacimiento, rol);
            return true;
        } else {
            return false;
        }
    }

    public static boolean eliminar(String cedula, String rol) {
        List<Usuario> usuarios = usuariosRole.get(rol);
        if (usuarios != null) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getCedula().equals(cedula)) {
                    usuarios.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean actualizarBaseDatosUsuario(String cedula, String usuario, String password,
            Timestamp fechaNacimiento, String rol) {
        Resultados result2 = null;
        try {
            result2 = db.searchUsuario("admin", "admin1234", "Administrador", cedula, rol);
        } catch (Exception e) {
            System.err.println(e);
        }
        if (result2 != null && result2.getDatos().length != 0) {
            Object[][] datos2 = result2.getDatos();

            boolean needsUpdate = !datos2[0][2].equals(usuario) ||
                    !Usuario.check2Password(password, datos2[0][3].toString());

            if (needsUpdate) {
                try {
                    int usuarioCreado = db.manipulateUsuario("admin", "admin1234", "Administrador", cedula, usuario,
                            Usuario.hashPassword(password), rol, fechaNacimiento);
                    if (usuarioCreado > 0) {
                        System.out.println(
                                "Actualizado USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
                    } else {
                        System.out.println("Se necesita actualizar el USUARIO en la base de datos y no se ha podido. "
                                + usuario + " " + cedula + " " + rol);
                        return false;
                    }
                } catch (Exception e) {
                    System.err.println("ERROR al actualizar el USUARIO en la base de datos. " + usuario + " " + cedula
                            + " " + rol + "\n" + e);
                    return false;
                }
                return true;
            } else {
                System.out
                        .println("NO actualizar el USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
            }
        }
        return false;
    }

    private static boolean actualizarBaseDatosUsuarioPasswordHash(String cedula, String usuario, String passwordHash,
            Timestamp fechaNacimiento, String rol) {
        Resultados result2 = null;
        try {
            result2 = db.searchUsuario("admin", "admin1234", "Administrador", cedula, rol);
        } catch (Exception e) {
            System.err.println(e);
        }
        if (result2 != null && result2.getDatos().length != 0) {
            try {
                int usuarioCreado = db.manipulateUsuario("admin", "admin1234", "Administrador", cedula, usuario,
                        passwordHash, rol, fechaNacimiento);
                if (usuarioCreado > 0) {
                    System.out
                            .println("Actualizado USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
                } else {
                    System.out.println("Se necesita actualizar el USUARIO en la base de datos y no se ha podido. "
                            + usuario + " " + cedula + " " + rol);
                    return false;
                }
            } catch (Exception e) {
                System.err.println("ERROR al actualizar el USUARIO en la base de datos. " + usuario + " " + cedula + " "
                        + rol + "\n" + e);
                return false;
            }
            return true;
        }
        return false;
    }
}
