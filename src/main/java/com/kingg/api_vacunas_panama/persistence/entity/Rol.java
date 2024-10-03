package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kingg.api_vacunas_panama.util.RolesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "roles", indexes = {
        @Index(name = "uq_roles_rol", columnList = "nombre_rol", unique = true)
})
@NoArgsConstructor
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Short id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @Nationalized
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @ManyToMany
    @JoinTable(name = "roles_permisos",
            joinColumns = @JoinColumn(name = "rol"),
            inverseJoinColumns = @JoinColumn(name = "permiso"))
    @JsonManagedReference
    private Set<Permiso> permisos = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    public Rol(RolesEnum nombre, String descripcion, Set<Permiso> permisos) {
        this.nombre = nombre.name();
        this.descripcion = descripcion;
        this.permisos = permisos;
    }

    public void setNombre(RolesEnum rol) {
        this.nombre = rol.name();
    }

}