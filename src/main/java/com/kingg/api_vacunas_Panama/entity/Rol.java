package com.kingg.api_vacunas_panama.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "roles", indexes = {
        @Index(name = "ix_roles_nombre", columnList = "nombre_rol")
        }, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nombre_rol"})
})
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private Integer id;

    @Size(max = 25)
    @NotNull
    @Nationalized
    @Column(name = "nombre_rol", nullable = false, length = 25)
    private String nombreRol;

    @Size(max = 100)
    @Nationalized
    @Column(name = "descripcion_rol", length = 100)
    private String descripcionRol;

    @ManyToMany
    @JoinTable(name = "roles_permisos",
            joinColumns = @JoinColumn(name = "id_permiso"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    @JsonManagedReference
    private Set<Permiso> permisos = new LinkedHashSet<>();

    public Rol() {
    }

    public Rol(Integer id, String nombreRol, String descripcionRol, Set<Permiso> permisos) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcionRol = descripcionRol;
        this.permisos = permisos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

}