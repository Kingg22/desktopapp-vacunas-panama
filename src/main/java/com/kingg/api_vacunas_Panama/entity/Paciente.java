package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes", indexes = {
        @Index(name = "ix_pacientes_nombre_apellido", columnList = "nombre_paciente, apellido1_paciente, apellido2_paciente"),
        @Index(name = "ix_pacientes_correo", columnList = "correo_electronico_paciente", unique = true),
        @Index(name = "ix_pacientes_telefono", columnList = "telefono_paciente", unique = true)
})
public class Paciente {
    @Id
    @Size(max = 20)
    @Nationalized
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "nombre_paciente", nullable = false, length = 50)
    private String nombrePaciente;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "apellido1_paciente", nullable = false, length = 50)
    private String apellido1Paciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "apellido2_paciente", length = 50)
    private String apellido2Paciente;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "edad_calculada")
    private Integer edadCalculada;

    @NotNull
    @Column(name = "sexo", nullable = false)
    private Character sexo;

    @Size(max = 15)
    @Nationalized
    @Column(name = "telefono_paciente", length = 15)
    private String telefonoPaciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "correo_electronico_paciente", length = 50)
    private String correoElectronicoPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    @ManyToMany(mappedBy = "pacientes")
    private Set<Dosis> dosis = new LinkedHashSet<>();

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

    public String getApellido1Paciente() {
        return apellido1Paciente;
    }

    public void setApellido1Paciente(String apellido1Paciente) {
        this.apellido1Paciente = apellido1Paciente;
    }

    public String getApellido2Paciente() {
        return apellido2Paciente;
    }

    public void setApellido2Paciente(String apellido2Paciente) {
        this.apellido2Paciente = apellido2Paciente;
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

    public Set<Dosis> getDosis() {
        return dosis;
    }

    public void setDosis(Set<Dosis> dosis) {
        this.dosis = dosis;
    }

}