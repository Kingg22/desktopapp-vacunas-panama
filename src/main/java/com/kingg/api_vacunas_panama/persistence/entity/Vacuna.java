package com.kingg.api_vacunas_panama.persistence.entity;

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
@Table(name = "vacunas", indexes = {
        @Index(name = "ix_vacunas_nombre", columnList = "nombre_vacuna")
})
@NoArgsConstructor
@Getter
@Setter
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "edad_minima_meses")
    private Short edadMinimaMeses;

    @Column(name = "intervalo_dosis_1_2_meses")
    private Float intervaloDosisMeses;

    @Enumerated(EnumType.STRING)
    @Column(name = "dosis_maxima", columnDefinition = "CHAR(2)")
    private NumDosisEnum dosisMaxima;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "idVacuna")
    private Set<Dosis> dosis = new LinkedHashSet<>();

    public Vacuna(String nombre, Short edadMinimaMeses, Float intervaloDosisMeses) {
        this.nombre = nombre;
        this.edadMinimaMeses = edadMinimaMeses;
        this.intervaloDosisMeses = intervaloDosisMeses;
    }

}