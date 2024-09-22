package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kingg.api_vacunas_panama.util.NumDosisEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "dosis")
@NoArgsConstructor
@Getter
@Setter
@NamedStoredProcedureQuery(name = "Dosis.insert", procedureName = "sp_vacunas_insert_dosis", parameters = {
        @StoredProcedureParameter(name = "cedula_paciente", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "fecha_aplicacion", mode = ParameterMode.IN, type = LocalDateTime.class),
        @StoredProcedureParameter(name = "numero_dosis", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "uuid_vacuna", mode = ParameterMode.IN, type = UUID.class),
        @StoredProcedureParameter(name = "nombre_vacuna", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "uuid_sede", mode = ParameterMode.IN, type = UUID.class),
        @StoredProcedureParameter(name = "nombre_sede", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "lote", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "return", mode = ParameterMode.OUT, type = Integer.class)
})
public class Dosis {
    @Id
    @Column(name = "id_dosis", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDateTime fechaAplicacion;

    @Size(max = 2)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "numero_dosis", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private NumDosisEnum numeroDosis;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vacuna", nullable = false)
    private Vacuna idVacuna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede")
    private Sede idSede;

    @Size(max = 50)
    @Nationalized
    @Column(name = "lote_dosis", length = 50)
    private String loteDosis;

    @ManyToMany
    @JoinTable(name = "pacientes_dosis",
            joinColumns = @JoinColumn(name = "id_dosis"),
            inverseJoinColumns = @JoinColumn(name = "cedula_paciente"))
    @JsonBackReference
    private Set<Paciente> pacientes = new LinkedHashSet<>();

    public Dosis(LocalDateTime fechaAplicacion, NumDosisEnum numeroDosis, Vacuna idVacuna, Sede idSede) {
        this.fechaAplicacion = fechaAplicacion;
        this.numeroDosis = numeroDosis;
        this.idVacuna = idVacuna;
        this.idSede = idSede;
    }

}