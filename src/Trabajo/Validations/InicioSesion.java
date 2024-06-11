package Trabajo.Validations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.*;

class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String usuario;
    private String passwordHash;

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
}

public class InicioSesion {
    private static List<Usuario> usuarios = new ArrayList<Usuario>();

    public static boolean autentificar(String usuario, String password) {
        Usuario consultado = obtener(usuario);
        if (consultado != null) {
            return consultado.checkPassword(password);
        } else {
            return false;
        }
    }

    private int buscar(String cedula) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getCedula().equals(cedula)) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static Usuario obtener(String usuario) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getUsuario().equals(usuario)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public boolean insertar(String nombre, String apellido, String cedula, String correo, String usuario, String password) {
        if(buscar(cedula) == Integer.MIN_VALUE) {
            return usuarios.add(new Usuario(nombre, apellido, cedula, correo, usuario, password));
        } else {
            return false;
        }
    }

    public boolean modificarDatos(String cedula, String nombre, String apellido, String correo) {
        int i = buscar(cedula);
        if(i != Integer.MIN_VALUE) {
            usuarios.get(i).modificarDatos(nombre, apellido, cedula, correo);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarCredenciales(String cedula, String usuario, String password) {
        int i = buscar(cedula);
        if(i != Integer.MIN_VALUE) {
            usuarios.get(i).modificarCredenciales(usuario, password);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(String cedula) {
        int i = buscar(cedula);
        if(i != Integer.MIN_VALUE) {
            usuarios.remove(i);
            return true;
        } else {
            return false;
        }
    }
}
