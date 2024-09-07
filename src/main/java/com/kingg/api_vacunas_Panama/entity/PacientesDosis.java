package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes_dosis")
public class PacientesDosis {
    @EmbeddedId
    private PacientesDosisId id;

    @MapsId("cedulaPaciente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cedula_paciente", nullable = false)
    private Paciente cedulaPaciente;

    @MapsId("idDosis")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dosis", nullable = false)
    private Dosis idDosis;

    public PacientesDosisId getId() {
        return id;
    }

    public void setId(PacientesDosisId id) {
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