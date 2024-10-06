package com.kingg.api_vacunas_panama.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pacientes_dosis")
public class PacientesDosis {
    @EmbeddedId
    private PacientesDosisId id;

    @MapsId("paciente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente", nullable = false)
    private Paciente paciente;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @MapsId("dosis")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dosis")
    private Dosis dosis;

}