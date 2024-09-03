package com.kingg.api_vacunas_Panama.dto;

import java.time.LocalDateTime;

public class PacienteDTO {
    private String cedula;
    private String nombre;
    private String apellido;
    private Character sexo;
    private Integer edad;
    private LocalDateTime fecha_nacimiento;
    private String telefono;
    private String email;
    private DireccionDTO direccion;

    public PacienteDTO() {

    }

    public PacienteDTO(String cedula, String nombre, String apellido, Character sexo, LocalDateTime fecha_nacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public PacienteDTO(String cedula, String nombre, String apellido, Character sexo, Integer edad, LocalDateTime fecha_nacimiento, String telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Character getSexo() {
        return sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }
}
