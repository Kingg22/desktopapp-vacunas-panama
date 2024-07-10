package Logica.Validations;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Timestamp;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private Timestamp fechaNacimiento;
    private String usuario;
    private String passwordHash;
    private Preferencias prefs;

    public Usuario(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.passwordHash = hashpassword(password);
    }

    public Usuario(String cedula, String usuario, String passwordHash, Timestamp fechaNacimiento) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.passwordHash = passwordHash;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void modificarDatos(String nombre, String apellido, String cedula, Timestamp fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void modificarCredenciales(String usuario, String password) {
        this.usuario = usuario;
        this.passwordHash = hashpassword(password);
    }

    public void modificarUsuario(String cedula, String usuario, String passwordHash, Timestamp fechaNacimiento) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.passwordHash = passwordHash;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void modificarCompleto(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.passwordHash = hashpassword(password);
    }

    public static String hashpassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }

    public static boolean check2Password(String password, String passwordHash) {
        return BCrypt.checkpw(password, passwordHash);
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

    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String toString() {
        return nombre + " " + apellido + " " + cedula + " " + fechaNacimiento + " " + usuario;
    }

    public void setPrefs() {
        prefs = new Preferencias();
    }

    public Preferencias getPrefs() {
        return prefs;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
