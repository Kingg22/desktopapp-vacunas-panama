package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "permisos", indexes = {
        @Index(name = "ix_permisos_nombre", columnList = "nombre_permiso"),
        @Index(name = "uq_permisos_nombre", columnList = "nombre_permiso", unique = true)
})
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "nombre_permiso", nullable = false, length = 50)
    private String nombrePermiso;

    @Size(max = 100)
    @Nationalized
    @Column(name = "descripcion_permiso", length = 100)
    private String descripcionPermiso;

    public Permiso() {
    }

    public Permiso(Integer id, String nombrePermiso, String descripcionPermiso) {
        this.id = id;
        this.nombrePermiso = nombrePermiso;
        this.descripcionPermiso = descripcionPermiso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

}