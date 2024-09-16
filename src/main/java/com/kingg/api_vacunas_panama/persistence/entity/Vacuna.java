package com.kingg.api_vacunas_panama.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

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
    @Column(name = "id_vacuna", nullable = false)
    private UUID id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_vacuna", nullable = false, length = 100)
    private String nombreVacuna;

    @Column(name = "edad_minima_meses")
    private Short edadMinimaMeses;

    @Column(name = "intervalo_dosis_1_2_meses")
    private Float intervaloDosisMeses;

    @OneToMany(mappedBy = "idVacuna")
    private Set<Dosis> dosis = new LinkedHashSet<>();

    public Vacuna(String nombreVacuna, Short edadMinimaMeses, Float intervaloDosisMeses) {
        this.nombreVacuna = nombreVacuna;
        this.edadMinimaMeses = edadMinimaMeses;
        this.intervaloDosisMeses = intervaloDosisMeses;
    }

}