package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PacientesDosisId implements Serializable {
    @Serial
    private static final long serialVersionUID = 6526647629932400742L;
    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "cedula_paciente", nullable = false, length = 20)
    private String cedulaPaciente;

    @NotNull
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
        PacientesDosisId entity = (PacientesDosisId) o;
        return Objects.equals(this.idDosis, entity.idDosis) &&
                Objects.equals(this.cedulaPaciente, entity.cedulaPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDosis, cedulaPaciente);
    }

}