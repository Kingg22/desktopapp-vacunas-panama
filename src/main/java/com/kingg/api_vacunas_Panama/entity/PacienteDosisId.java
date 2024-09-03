package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PacienteDosisId implements java.io.Serializable {
    private static final long serialVersionUID = -5431680245325751262L;
    @Column(name = "cedula_paciente", nullable = false, length = 20)
    private String cedulaPaciente;

    @Column(name = "id_dosis", nullable = false)
    private Integer idDosis;

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Integer getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(Integer idDosis) {
        this.idDosis = idDosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PacienteDosisId entity = (PacienteDosisId) o;
        return Objects.equals(this.idDosis, entity.idDosis) &&
                Objects.equals(this.cedulaPaciente, entity.cedulaPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDosis, cedulaPaciente);
    }

}