package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;


@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Column(name = "nombre_paciente", nullable = false, length = 50)
    private String nombrePaciente;

    @Column(name = "apellido_paciente", nullable = false, length = 50)
    private String apellidoPaciente;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "edad_calculada")
    private Integer edadCalculada;

    @Column(name = "sexo", nullable = false)
    private Character sexo;

    @Column(name = "telefono_paciente", length = 15)
    private String telefonoPaciente;

    @Column(name = "correo_electronico_paciente", length = 50)
    private String correoElectronicoPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdadCalculada() {
        return edadCalculada;
    }

    public void setEdadCalculada(Integer edadCalculada) {
        this.edadCalculada = edadCalculada;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getCorreoElectronicoPaciente() {
        return correoElectronicoPaciente;
    }

    public void setCorreoElectronicoPaciente(String correoElectronicoPaciente) {
        this.correoElectronicoPaciente = correoElectronicoPaciente;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

}