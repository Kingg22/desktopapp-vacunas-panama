package Logica.Validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InicioSesion {
    private static HashMap<String, List<Usuario>> usuariosRole = new HashMap<String, List<Usuario>>(); // IMPLEMENTAR HASHMAP DE USUARIOS SEGÚN ROLES

    public InicioSesion() {
        String[] roles = {"Paciente", "Doctor - Enfermera", "Proveedor", "Administrativo", "Autoridad", "Administrador"};
        for (String role : roles) {
            usuariosRole.put(role, new ArrayList<Usuario>());
        }
        insertar("Rey", "Acosta", "8-1024-1653", "2005-07-22", "admin", "admin1234", "Administrador");
        insertar("Rey", "Acosta", "8-1024-1653", "2005-07-22", "admin", "admin1234", "Proveedor");
        insertar("Rey", "Acosta", "8-1024-1653", "2005-07-22", "admin", "admin1234", "Paciente");
        insertar("Rey", "Acosta", "8-1024-1653", "2005-07-22", "admin", "admin1234", "Doctor - Enfermera");
        insertar("Rey", "Acosta", "8-1024-1653", "2005-07-22", "admin", "admin1234", "Administrativo");
        insertar("Rey", "Acosta", "8-1024-1653", "2005-07-22", "admin", "admin1234", "Autoridad");
    }

    public static boolean autentificar(String usuario, String password, String rol) {
        Usuario consultado = obtener(usuario, rol);
        if (consultado != null) {
            return consultado.checkPassword(password);
        } else {
            return false;
        }
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

    public static boolean restaurar(String cedula, String fechaNacimiento, String rol) {
        Usuario encontrado = buscar(cedula, rol);
        if (encontrado != null) {
            if (encontrado.getFechaNacimiento().equals(fechaNacimiento)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean insertar(String nombre, String apellido, String cedula, String fechaNacimiento, String usuario, String password, String rol) {
        if (buscar(cedula, rol) == null) {
            return usuariosRole.get(rol).add(new Usuario(nombre, apellido, cedula, fechaNacimiento, usuario, password));
        } else {
            return false;
        }
    }

    public static boolean modificarDatos(String cedula, String nombre, String apellido, String correo, String rol) {
        Usuario usuario = buscar(cedula, rol);
        if (usuario != null) {
            usuario.modificarDatos(nombre, apellido, cedula, correo);
            return true;
        } else {
            return false;
        }
    }

    public static boolean modificarCredenciales(String cedula, String usuarioNuevo, String passwordNuevo, String rol) {
        Usuario usuarioF = buscar(cedula, rol);
        if (usuarioF != null) {
            usuarioF.modificarCredenciales(usuarioNuevo, passwordNuevo);
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
}

