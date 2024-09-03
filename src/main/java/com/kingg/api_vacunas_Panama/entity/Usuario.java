package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(name = "ck_usuario_tipo_vario", columnNames = {"cedula", "tipo"})
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "clave_hash", nullable = false, length = 60)
    private String claveHash;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @ColumnDefault("getdate()")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ColumnDefault("getdate()")
    @Column(name = "last_used")
    private LocalDateTime lastUsed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

}