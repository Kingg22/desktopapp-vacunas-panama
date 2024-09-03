package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes_dosis")
public class PacienteDosis {
    @EmbeddedId
    private PacienteDosisId id;

    @MapsId("cedulaPaciente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cedula_paciente", nullable = false)
    private Paciente cedulaPaciente;

    @MapsId("idDosis")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dosis", nullable = false)
    private Dosis idDosis;

    public PacienteDosisId getId() {
        return id;
    }

    public void setId(PacienteDosisId id) {
        this.id = id;
    }

    public Paciente getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(Paciente cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Dosis getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(Dosis idDosis) {
        this.idDosis = idDosis;
    }

}