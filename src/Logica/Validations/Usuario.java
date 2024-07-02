package Logica.Validations;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaNacimiento;
    private String usuario;
    private String passwordHash;
    private Preferencias prefs;

    public Usuario(String nombre, String apellido, String cedula, String fechaNacimiento, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.passwordHash = hashpassword(password);
    }

    public void modificarDatos(String nombre, String apellido, String cedula, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = correo;
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

    public String getFechaNacimiento() {
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
}
