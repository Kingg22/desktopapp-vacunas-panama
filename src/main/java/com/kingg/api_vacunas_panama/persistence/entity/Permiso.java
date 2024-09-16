package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "permisos", indexes = {
        @Index(name = "uq_permisos_nombre", columnList = "nombre_permiso", unique = true)
})
@NoArgsConstructor
@Getter
@Setter
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso", nullable = false)
    private Short id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_permiso", nullable = false, length = 100)
    private String nombrePermiso;

    @Size(max = 100)
    @Nationalized
    @Column(name = "descripcion_permiso", length = 100)
    private String descripcionPermiso;

    @ManyToMany
    @JoinTable(name = "roles_permisos",
            joinColumns = @JoinColumn(name = "id_permiso"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    @JsonBackReference
    private Set<Rol> roles = new LinkedHashSet<>();

}