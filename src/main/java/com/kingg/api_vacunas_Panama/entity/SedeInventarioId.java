package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Embeddable
public class SedeInventarioId implements java.io.Serializable {
    private static final long serialVersionUID = 2892226489003500554L;
    @ColumnDefault("1")
    @Column(name = "id_sede", nullable = false)
    private Integer idSede;

    @Column(name = "id_vacuna", nullable = false)
    private Integer idVacuna;

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SedeInventarioId entity = (SedeInventarioId) o;
        return Objects.equals(this.idSede, entity.idSede) &&
                Objects.equals(this.idVacuna, entity.idVacuna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSede, idVacuna);
    }

}