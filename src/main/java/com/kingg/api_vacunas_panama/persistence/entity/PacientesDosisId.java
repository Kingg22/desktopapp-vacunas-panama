package com.kingg.api_vacunas_panama.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PacientesDosisId implements Serializable {
    @Serial
    private static final long serialVersionUID = 1758063147274896824L;
    @NotNull
    @Column(name = "paciente", nullable = false)
    private UUID idPaciente;

    @NotNull
    @Column(name = "dosis", nullable = false)
    private UUID idDosis;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PacientesDosisId entity = (PacientesDosisId) o;
        return Objects.equals(this.idPaciente, entity.idPaciente) &&
                Objects.equals(this.idDosis, entity.idDosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaciente, idDosis);
    }

}