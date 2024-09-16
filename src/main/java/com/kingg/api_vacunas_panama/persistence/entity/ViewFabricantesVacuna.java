package com.kingg.api_vacunas_panama.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Nationalized;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_fabricantes_vacunas")
public class ViewFabricantesVacuna {
    @Id
    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "\"Nombre fabricante\"", nullable = false, length = 100)
    private String nombreFabricante;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "\"Vacuna ofrecida\"", nullable = false, length = 100)
    private String vacunaOfrecida;

    @Column(name = "\"Edad mínima recomendada en meses\"")
    private Short edadMinRecomendadaEnMeses;

    @Column(name = "\"Intervalo recomendado dosis 1 y 2 en meses\"")
    private Float intervaloRecomendadoDosisEnMeses;

    @Size(max = 100)
    @Nationalized
    @Column(name = "\"Enfermedad que previene\"", length = 100)
    private String enfermedadQuePreviene;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Nivel de gravedad enfermedad\"", length = 50)
    private String nivelDeGravedadEnfermedad;

}