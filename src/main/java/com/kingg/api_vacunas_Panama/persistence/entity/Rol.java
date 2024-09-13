package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "id_rol", nullable = false)
    private Short id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_rol", nullable = false, length = 100)
    private String nombreRol;

    @Size(max = 100)
    @Nationalized
    @Column(name = "descripcion_rol", length = 100)
    private String descripcionRol;

    @ManyToMany
    @JoinTable(name = "roles_permisos",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_permiso"))
    @JsonManagedReference
    private Set<Permiso> permisos = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    public Rol(String nombreRol, String descripcionRol, Set<Permiso> permisos) {
        this.nombreRol = nombreRol;
        this.descripcionRol = descripcionRol;
        this.permisos = permisos;
    }

}