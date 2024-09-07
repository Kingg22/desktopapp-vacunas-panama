package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RolesPermisosId implements Serializable {
    @Serial
    private static final long serialVersionUID = -953250446561309828L;
    @NotNull
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @NotNull
    @Column(name = "id_permiso", nullable = false)
    private Integer idPermiso;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolesPermisosId entity = (RolesPermisosId) o;
        return Objects.equals(this.idRol, entity.idRol) &&
                Objects.equals(this.idPermiso, entity.idPermiso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, idPermiso);
    }

}