package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "dosis")
@NoArgsConstructor
@Getter
@Setter
public class Dosis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_dosis", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDateTime fechaAplicacion;

    @Size(max = 2)
    @NotNull
    @Column(name = "numero_dosis", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String numeroDosis;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vacuna", nullable = false)
    private Vacuna idVacuna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede")
    private Sede idSede;

    @ManyToMany
    @JoinTable(name = "pacientes_dosis",
            joinColumns = @JoinColumn(name = "id_dosis"),
            inverseJoinColumns = @JoinColumn(name = "cedula_paciente"))
    @JsonBackReference
    private Set<Paciente> pacientes = new LinkedHashSet<>();

    public Dosis(LocalDateTime fechaAplicacion, String numeroDosis, Vacuna idVacuna, Sede idSede) {
        this.fechaAplicacion = fechaAplicacion;
        this.numeroDosis = numeroDosis;
        this.idVacuna = idVacuna;
        this.idSede = idSede;
    }

}