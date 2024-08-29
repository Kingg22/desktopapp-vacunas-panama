package logic.user_management;

import logic.connexions.DatabaseOperaciones;
import logic.connexions.Resultados;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/*
    Se implementó una lógica de synchronize y esperar a inicializar. Posibles problemas:
    1. Los métodos public insertar, buscar y modificar obligatorias no esperan a inicializar la clase (Investigando),
    ya que, la inicialización los necesita, fuera de estos pueden obtener u ocasionar errores por falta de datos.
    2. Se debe tener cuidado con ocasionar un deadlock al llamar un método dentro de la inicialización, que está
    esperando que se inicialice la clase.

    Se debe investigar si implementar el uso de CountDownLatch o CompletableFuturo en esta clase.
    Se recomienda para entornos responsive hacer la llamada de forma asíncrona porque puede tardar unos ms.
 */
public class UserManager {
    private static final HashMap<String, List<User>> usuariosRole = new HashMap<>();
    private static final DatabaseOperaciones db = new DatabaseOperaciones();
    private static String token;
    private static boolean initialized = false;
    private static final Object initLock = new Object();

    static {
        long startTime = System.currentTimeMillis();

        mostrarMensaje(startTime);
        initialize();

        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("\u001B[32m\tLa inicialización tardó: " + elapsed + " ms\u001B[0m");
    }

    private static void mostrarMensaje(long startTime) {
        JDialog dialogCargar = new JDialog();
        JLabel label = new JLabel("Cargando información de los usuarios. Por favor, espere...", SwingConstants.CENTER);

        dialogCargar.setTitle("Inicio Sesión");
        dialogCargar.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogCargar.setModal(true);
        dialogCargar.setBackground(Color.white);
        dialogCargar.setResizable(false);
        dialogCargar.setSize(new Dimension(350, 100));

        label.setForeground(Color.black);
        dialogCargar.getContentPane().add(label, BorderLayout.CENTER);
        dialogCargar.setLocationRelativeTo(null);
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                dialogCargar.dispose();
                System.out.println("\tYa no se muestra el mensaje.");
                long endTime = System.currentTimeMillis();
                long elapsed = endTime - startTime;
                System.out.println("\tEl mensaje tardó: " + elapsed + " ms\u001B[0m");
            }
        }, 3000);
        System.out.println("\u001B[32m\tMostrando mensaje de carga");
        dialogCargar.setVisible(true);
        dialogCargar.requestFocusInWindow();
    }

    // inicialización de operaciones
    private static void initialize() {
        synchronized (initLock) {
            if (!initialized) {
                inicializarRoles();
                // TODO cambiar los datos iniciales a privados
                token = inicializarAdminLocal();
                System.out.println("Token de la aplicación obtenido\n");
                sincronizarUsuariosBD();
                System.out.println();
                initialized = true;
                initLock.notifyAll();
                extendSessionApp();
            }
        }
    }

    private static void inicializarRoles() {
        String[] roles = { "Paciente", "Doctor - Enfermera", "Fabricante", "Administrativo", "Autoridad",
                "Administrador" };
        for (String role : roles) {
            usuariosRole.put(role, new ArrayList<>());
        }
        usuariosRole.put("App", new ArrayList<>(1));
    }

    private static String inicializarAdminLocal() {
        usuariosRole.get("Administrador").add(new User("8-1024-1653", "admin", User.hashPassword("admin1234"),
                Timestamp.valueOf("2005-07-22 00:00:00")));
        usuariosRole.get("App").add(new User("A-12345-123456", "applicationJava", User.hashPassword("app20.24Java"),
                Timestamp.valueOf("2024-06-01 00:00:00")));
        System.out.println("Administrador insertado local. 8-1024-1653 admin");
        System.out.println("Usuario de la aplicación insertado.");
        return TokenManager.generateToken("A-12345-123456", "App");
    }

    private static void sincronizarUsuariosBD() {
        try {
            Object[][] datas = {
                    { null, null, "A-12345-123456", "2024-06-01 00:00:00", 'X', null, null, null, null,
                            "applicationJava", "app20.24Java", "App" },
                    { "Rey", "Acosta", "8-1024-1653", "2005-07-22 00:00:00", 'M', null, null, null, null, "admin",
                            "admin1234", "Administrador" } };
            // Verificar tanto localmente como en la base de datos
            for (Object[] datos : datas) {
                Resultados result = db.searchUsuario(token, (String) datos[2], (String) datos[11]);
                boolean existsInDB = result != null && result.getDatos() != null && result.getDatos().length > 0;

                if (!existsInDB) {
                    insertar((String) datos[0], (String) datos[1], (String) datos[2],
                            Timestamp.valueOf((String) datos[3]), (char) datos[4], (String) datos[5], (String) datos[6],
                            (String) datos[7], (String) datos[8], (String) datos[9], (String) datos[10],
                            (String) datos[11]);
                } else {
                    // Actualizar solo si es necesario
                    if (modificarObligatorias((String) datos[2], (String) datos[0], (String) datos[1],
                            Timestamp.valueOf((String) datos[3]), (String) datos[9], (String) datos[10],
                            (String) datos[11]))
                        System.out.println("Se ha actualizado localmente un usuario predeterminado. CIP:" + datos[2]
                                + " user: " + datos[9] + " Rol: " + datos[11]);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un fatal error. Cerrar el programa y contacte a soporte",
                    "ERROR UserManager Admin", JOptionPane.ERROR_MESSAGE);
        }
        try {
            // TODO cambiar a solo los primeros 25 usuarios last used
            System.out.println("Verificar los usuarios de la base de datos.");
            Resultados result = db.showUsuarios(token);
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
                    "ERROR UserManager", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void sincronizarUsuarios(Resultados result) throws SQLException {
        Object[][] da = result.getDatos();
        for (Object[] dato : da) {
            String cedula = (String) dato[1];
            String rol = DatabaseOperaciones.getTipo((Integer) dato[4]);
            if (rol.equals("App")) {
                continue;
            }

            User userLocal = buscar(cedula, rol);
            if (userLocal == null) {
                usuariosRole.get(rol).add(new User(cedula, (String) dato[2], (String) dato[3], (Timestamp) dato[5]));
                System.out.println("Se ha insertado USUARIO local encontrado en la base de datos. CIP:" + cedula
                        + " user: " + dato[2] + " Rol: " + rol);
            } else {
                actualizarUsuarioLocal(userLocal, dato, rol);
            }
        }
    }

    private static void actualizarUsuarioLocal(User userLocal, Object[] dato, String rol) {
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

    private static void insertarUsuariosPredeterminados() throws SQLException, ClassNotFoundException {
        String[] roles = { "Fabricante", "Doctor - Enfermera", "Autoridad", "Administrativo", "Administrador",
                "Paciente" };
        Object[] datos = { "Rey", "Acosta", "8-1024-1653", "2005-07-22 00:00:00", 'M', null, null, null, null, "admin",
                "admin1234" };
        for (String rol : roles) {
            if (rol.equals("Paciente")) {
                datos[2] = "2-4558-5479";
            }
            // Verificar tanto localmente como en la base de datos
            User usuarioLocal = buscar((String) datos[2], rol);
            Resultados result = db.searchUsuario(token, (String) datos[2], rol);
            boolean existsInDB = result != null && result.getDatos().length != 0;

            if (usuarioLocal == null && !existsInDB) {
                insertar((String) datos[0], (String) datos[1], (String) datos[2], Timestamp.valueOf((String) datos[3]),
                        (char) datos[4], (String) datos[5], (String) datos[6], (String) datos[7], (String) datos[8],
                        (String) datos[9], (String) datos[10], rol);
            } else if (usuarioLocal != null && existsInDB) {
                // Actualizar solo si es necesario
                if (modificarObligatorias((String) datos[2], (String) datos[0], (String) datos[1],
                        Timestamp.valueOf((String) datos[3]), (String) datos[9], (String) datos[10], rol))
                    System.out.println("Se ha actualizado localmente un usuario predeterminado. CIP:" + datos[2]
                            + " user: " + datos[9] + " Rol: " + rol);
            }
        }
    }

    private synchronized static void extendSessionApp() {
        new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                User userApp = buscar("A-12345-123456", "App");
                while (true) {
                    try {
                        // Extiende el token y espera el resultado
                        String tokenNuevo = SessionManager.extendSessionImmediately(token, userApp, "App").get();
                        if (tokenNuevo == null) {
                            // Maneja el caso donde la extensión del token falla
                            JOptionPane.showMessageDialog(null,
                                    "Ha ocurrido un error obteniendo el token del app. Contactar a soporte.\n" +
                                            "La app no tiene token para realizar operaciones con usuarios. " +
                                            "Recomendamos reiniciar el programa.",
                                    "UserManager App Token null", JOptionPane.ERROR_MESSAGE);
                        } else {
                            System.out.println("Token del app actualizado");
                            token = tokenNuevo;
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.err.println(e);
                        JOptionPane.showMessageDialog(null,
                                "Ha ocurrido un error en el evento de la aplicación obtiene su token por vencimiento. Contactar a soporte.\n"
                                        +
                                        "No hay certeza si el app tiene token para realizar operaciones con usuarios. Recomendamos reiniciar el programa.",
                                "ERROR UserManager App Token", JOptionPane.ERROR_MESSAGE);
                        break; // Sale del bucle si hay un error
                    }

                    // Espera antes de intentar extender el token nuevamente
                    try {
                        Thread.sleep(System.currentTimeMillis() + 3500000); // Ajusta el tiempo de espera según sea
                                                                            // necesario
                    } catch (InterruptedException e) {
                        System.err.println(e);
                        break; // Sale del bucle si hay una interrupción
                    }
                }
                return null;
            }
        }.execute();
    }

    // métodos operacionales
    public static synchronized boolean autentificar(String usuario, String password, String rol) {
        esperarInicializacion();
        User consultado = obtener(usuario, rol);
        if (consultado != null) {
            return consultado.checkPassword(password);
        }
        return false;
    }

    public static synchronized User obtener(String usuario, String rol) {
        esperarInicializacion();
        List<User> users = usuariosRole.get(rol);
        if (users != null) {
            for (User u : users) {
                if (u.getUsuario().equals(usuario)) {
                    return u;
                }
            }
            // TODO buscar en la base de datos
        }
        return null;
    }

    public static synchronized User buscar(String cedula, String rol) {
        List<User> users = usuariosRole.get(rol);
        if (users != null) {
            for (User u : users) {
                if (u.getCedula().equals(cedula)) {
                    return u;
                }
            }
            // TODO buscar en la base de datos
        }
        return null;
    }

    public static synchronized boolean restaurar(String cedula, String fechaNacimiento, String rol) {
        esperarInicializacion();
        Timestamp fechaNacimientoNueva = Timestamp.valueOf(LocalDate.parse(fechaNacimiento).atStartOfDay());
        User encontrado = buscar(cedula, rol);
        if (encontrado != null) {
            return encontrado.getFechaNacimiento().equals(fechaNacimientoNueva);
        } else {
            return false;
        }
    }

    public static synchronized boolean insertar(String nombre, String apellido, String cedula,
            Timestamp fechaNacimiento, char sexo, String distrito, String direccion, String correo, String telefono,
            String usuario, String password, String rol) throws SQLException, ClassNotFoundException {
        // esperarInicializacion();
        if (rol.equals("Paciente")) {
            // Verificar si el paciente ya existe en la base de datos
            Resultados result = db.searchTablePaciente(token, cedula, null, null);
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
                        int actualizado = db.manipulatePaciente(token, cedula, nombre, apellido, fechaNacimiento, sexo,
                                telefono, correo, direccion, distrito);
                        if (actualizado > 0) {
                            System.out.println("Actualizado PACIENTE en la base de datos. " + usuario + " " + cedula);
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
                    int insertadoBD = db.manipulatePaciente(token, cedula, nombre, apellido, fechaNacimiento, sexo,
                            telefono, correo, direccion, distrito);
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
            usuariosRole.get(rol).add(new User(nombre, apellido, cedula, fechaNacimiento, correo, telefono, direccion,
                    distrito, usuario, password));
        } else {
            System.out.println(
                    "NO insertado USUARIO de forma local porque ya existe." + usuario + " " + cedula + " " + rol);
        }
        // Verificar si el usuario ya existe en la base de datos
        Resultados result2 = db.searchUsuario(token, cedula, rol);

        if (result2 != null && result2.getDatos().length != 0) {
            Object[][] datos2 = result2.getDatos();
            Timestamp fechaBD = Timestamp.valueOf(datos2[0][3].toString().replace(" ", "T"));

            boolean needsUpdate = !datos2[0][2].equals(usuario) ||
                    !User.check2Password(password, datos2[0][3].toString()) ||
                    !fechaNacimiento.equals(fechaBD);

            if (needsUpdate) {
                // Crear el usuario en la base de datos
                try {
                    int usuarioCreado = db.manipulateUsuario(token, cedula, usuario, User.hashPassword(password), rol,
                            fechaNacimiento);
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
        } else {
            // Insertar en la base de datos
            try {
                int usuarioCreado = db.manipulateUsuario(token, cedula, usuario, User.hashPassword(password), rol,
                        fechaNacimiento);
                if (usuarioCreado > 0) {
                    System.out
                            .println("Insertado el USUARIO en la base de datos. " + usuario + " " + cedula + " " + rol);
                } else {
                    System.err.println("Se necesita insertar el USUARIO en la base de datos y no se ha podido. "
                            + usuario + " " + cedula + " " + rol);
                    return false;
                }
            } catch (Exception e) {
                System.err.println("ERROR al insertar el USUARIO en la base de datos. " + usuario + " " + cedula + " "
                        + rol + "\n" + e);
                return false;
            }
            return true;
        }
        return false;
    }

    public static synchronized boolean modificarCompleto(String cedula, String nombre, String apellido,
            Timestamp fechaNacimiento, String correo, String telefono, String direccion, String distrito,
            String usuario, String password, String rol) {
        esperarInicializacion();
        User user = buscar(cedula, rol);
        if (user != null) {
            user.modificarCompleto(nombre, apellido, cedula, fechaNacimiento, correo, telefono, direccion, distrito,
                    usuario, password);
            return actualizarBaseDatosUsuario(cedula, usuario, password, fechaNacimiento, rol);
        } else {
            return false;
        }
    }

    public static synchronized boolean modificarDatos(String cedula, String nombre, String apellido,
            Timestamp fechaNacimiento, String rol) {
        esperarInicializacion();
        User usuario = buscar(cedula, rol);
        if (usuario != null) {
            usuario.modificarDatos(nombre, apellido, cedula, fechaNacimiento);
            return actualizarBaseDatosUsuarioPasswordHash(cedula, usuario.getUsuario(), usuario.getPasswordHash(),
                    fechaNacimiento, rol);
        } else {
            return false;
        }
    }

    public static synchronized boolean eliminar(String cedula, String rol) {
        esperarInicializacion();
        List<User> users = usuariosRole.get(rol);
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getCedula().equals(cedula)) {
                    users.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public static synchronized boolean modificarObligatorias(String cedula, String nombre, String apellido,
            Timestamp fechaNacimiento, String usuario, String password, String rol) {
        User user = buscar(cedula, rol);
        if (user != null) {
            user.modificarObligatorias(nombre, apellido, cedula, fechaNacimiento, usuario, password);
            return true;
        } else {
            return false;
        }
    }

    public static synchronized boolean modificarCredenciales(String cedula, String usuarioNuevo, String passwordNuevo,
            String rol) {
        esperarInicializacion();
        User userF = buscar(cedula, rol);
        if (userF != null) {
            userF.modificarCredenciales(usuarioNuevo, passwordNuevo);
            return actualizarBaseDatosUsuario(cedula, usuarioNuevo, passwordNuevo, userF.getFechaNacimiento(), rol);
        } else {
            return false;
        }
    }

    // métodos privados de la clase
    private static void esperarInicializacion() {
        synchronized (initLock) {
            while (!initialized) {
                try {
                    initLock.wait(); // Esperar hasta que la inicialización se complete
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private static boolean modificarUsuario(String cedula, String usuario, String passwordHash,
            Timestamp fechaNacimiento, String rol) {
        User userF = buscar(cedula, rol);
        if (userF != null) {
            userF.modificarUsuario(cedula, usuario, passwordHash, fechaNacimiento);
            return actualizarBaseDatosUsuarioPasswordHash(cedula, usuario, passwordHash, fechaNacimiento, rol);
        } else {
            return false;
        }
    }

    private static boolean actualizarBaseDatosUsuario(String cedula, String usuario, String password,
            Timestamp fechaNacimiento, String rol) {
        Resultados result2 = null;
        try {
            result2 = db.searchUsuario(token, cedula, rol);
        } catch (Exception e) {
            System.err.println(e);
        }
        if (result2 != null && result2.getDatos().length != 0) {
            Object[][] datos2 = result2.getDatos();

            boolean needsUpdate = !datos2[0][2].equals(usuario) ||
                    !User.check2Password(password, datos2[0][3].toString());

            if (needsUpdate) {
                try {
                    int usuarioCreado = db.manipulateUsuario(token, cedula, usuario, User.hashPassword(password), rol,
                            fechaNacimiento);
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
            result2 = db.searchUsuario(token, cedula, rol);
        } catch (Exception e) {
            System.err.println(e);
        }
        if (result2 != null && result2.getDatos().length != 0) {
            try {
                int usuarioCreado = db.manipulateUsuario(token, cedula, usuario, passwordHash, rol, fechaNacimiento);
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

    public static String getToken(long source) {
        if (source == Integer.MAX_VALUE - 1000) {
            return token;
        } else
            return null;
    }
}
