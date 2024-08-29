package logic.user_management;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Timestamp;

public class User {
    private String nombre;
    private String apellido;
    private String cedula;
    private Timestamp fechaNacimiento;
    private String correo;
    private String telefono;
    private String direccion;
    private String distrito;
    private String usuario;
    private String passwordHash;
    private Preferences prefs = new Preferences();

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean check2Password(String password, String passwordHash) {
        return BCrypt.checkpw(password, passwordHash);
    }

    public User(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.passwordHash = hashPassword(password);
    }

    public User(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String correo, String telefono, String direccion, String distrito, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.distrito = distrito;
        this.usuario = usuario;
        this.passwordHash = hashPassword(password);
    }

    public User(String cedula, String usuario, String passwordHash, Timestamp fechaNacimiento) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.passwordHash = passwordHash;
        this.fechaNacimiento = fechaNacimiento;
    }

    public User(String cedula, String usuario, String passwordHash, Timestamp fechaNacimiento, String correo, String telefono, String direccion, String distrito) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.passwordHash = passwordHash;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.distrito = distrito;
    }

    public void modificarDatos(String nombre, String apellido, String cedula, Timestamp fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void modificarDatos(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String correo, String telefono, String direccion, String distrito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.distrito = distrito;
    }

    public void modificarCredenciales(String usuario, String password) {
        this.usuario = usuario;
        this.passwordHash = hashPassword(password);
    }

    public void modificarUsuario(String cedula, String usuario, String passwordHash, Timestamp fechaNacimiento) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.passwordHash = passwordHash;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void modificarObligatorias(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.passwordHash = hashPassword(password);
    }

    public void modificarCompleto(String nombre, String apellido, String cedula, Timestamp fechaNacimiento, String correo, String telefono, String direccion, String distrito, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.passwordHash = hashPassword(password);
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.distrito = distrito;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }

    // getters
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

    public String[] toArray() {
        return new String[]{nombre, apellido, cedula, fechaNacimiento.toString(), correo, telefono, direccion, distrito};
    }

    public void setPrefs() {
        prefs = new Preferences();
    }

    public Preferences getPrefs() {
        return prefs;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
