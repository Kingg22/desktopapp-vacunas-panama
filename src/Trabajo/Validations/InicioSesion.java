package Trabajo.Validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.prefs.Preferences;

import org.springframework.security.crypto.bcrypt.*;

class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String usuario;
    private String passwordHash;
    private Preferencias prefs;

    public Usuario(String nombre, String apellido, String cedula, String correo, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.usuario = usuario;
        this.passwordHash = hashpassword(password);
    }

    public void modificarDatos(String nombre, String apellido, String cedula, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
    }

    public void modificarCredenciales(String usuario, String password) {
        this.usuario = usuario;
        this.passwordHash = hashpassword(password);
    }

    private String hashpassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String toString() {
        return nombre + " " + apellido + " " + cedula + " " + correo + " " + usuario;
    }

    public Preferencias getPrefs() {
        return prefs;
    }
}

public class InicioSesion {
    private static HashMap<String, List<Usuario>> usuariosRole = new HashMap<String, List<Usuario>>(); // IMPLEMENTAR HASHMAP DE USUARIOS SEGÚN ROLES

    public InicioSesion() {
        String[] roles = {"Paciente", "Doctor", "Proveedor", "Administrativo", "Autoridad", "Administrador"};
        for (String role : roles) {
            usuariosRole.put(role, new ArrayList<Usuario>());
        }
        insertar("admin", "admin", null, "admin@admin.com", "admin", "admin1234*", "Administrador");
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

    private static Usuario obtener(String usuario, String rol) {
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

    public boolean insertar(String nombre, String apellido, String cedula, String correo, String usuario, String password, String rol) {
        if (buscar(cedula, rol) == null) {
            return usuariosRole.get(rol).add(new Usuario(nombre, apellido, cedula, correo, usuario, password));
        } else {
            return false;
        }
    }

    public boolean modificarDatos(String cedula, String nombre, String apellido, String correo, String rol) {
        Usuario usuario = buscar(cedula, rol);
        if (usuario != null) {
            usuario.modificarDatos(nombre, apellido, cedula, correo);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarCredenciales(String cedula, String usuario, String password, String rol) {
        Usuario usuarioF = buscar(cedula, rol);
        if (usuarioF != null) {
            usuarioF.modificarCredenciales(usuario, password);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(String cedula, String rol) {
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

class Preferencias {
    private Preferences prefs = Preferences.userNodeForPackage(Usuario.class);

    public void setPrefInputs(boolean valor) {
        prefs.putBoolean("prefInput", valor);
        // emergente true, en tabla false
    }

    public boolean getPrefInput() {
        return prefs.getBoolean("prefInput", false);
    }

    public void setFontSize(int valor) {
        prefs.putInt("fontSize", valor);
    }

    public int getFontSize() {
        return prefs.getInt("fontSize", 12);
    }

    public void setFontName(String valor) {
        prefs.put("fontName", valor);
    }

    public String getFontName() {
        return prefs.get("fontName", "Arial");
    }

    public void setSede(String sede) {
        prefs.put("sede", sede);
    }

    public String getSede() {
        return prefs.get("sede", "Complejo Hospitalario Doctor Arnulfo Arias Madrid");
    }

    public void setExportFileType(String fileType) {
        prefs.put("exportFileType", fileType);
    }

    public String getExportFileType() {
        return prefs.get("exportFileType", "PDF");
    }
}