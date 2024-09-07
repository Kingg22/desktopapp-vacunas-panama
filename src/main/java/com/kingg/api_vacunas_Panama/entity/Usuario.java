package com.kingg.api_vacunas_panama.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios", indexes = {
        @Index(name = "ix_usuarios_usuario_correo", columnList = "cedula, usuario, correo_electronico_usuario"),
        @Index(name = "uq_usuarios_cedula", columnList = "cedula", unique = true),
        @Index(name = "ix_usuarios_username", columnList = "usuario", unique = true),
        @Index(name = "ix_usuarios_email", columnList = "correo_electronico_usuario", unique = true)
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Size(max = 50)
    @Nationalized
    @Column(name = "usuario", length = 50)
    private String username;

    @Size(max = 254)
    @Nationalized
    @Column(name = "correo_electronico_usuario", length = 254)
    private String correoElectronicoUsuario;

    @Size(max = 60)
    @NotNull
    @Nationalized
    @Column(name = "clave_hash", nullable = false, length = 60)
    private String claveHash;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_used")
    private LocalDateTime lastUsed;

    @ManyToMany
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    @JsonManagedReference
    private Set<Rol> roles = new LinkedHashSet<>();

    public Usuario() {
    }

    public Usuario(Integer id, String cedula, String username, String correoElectronicoUsuario, String claveHash, LocalDateTime fechaNacimiento, Boolean disabled, LocalDateTime createdAt, LocalDateTime lastUsed, Set<Rol> roles) {
        this.id = id;
        this.cedula = cedula;
        this.username = username;
        this.correoElectronicoUsuario = correoElectronicoUsuario;
        this.claveHash = claveHash;
        this.fechaNacimiento = fechaNacimiento;
        this.disabled = disabled;
        this.createdAt = createdAt;
        this.lastUsed = lastUsed;
        this.roles = roles;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreoElectronicoUsuario() {
        return correoElectronicoUsuario;
    }

    public void setCorreoElectronicoUsuario(String correoElectronicoUsuario) {
        this.correoElectronicoUsuario = correoElectronicoUsuario;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}