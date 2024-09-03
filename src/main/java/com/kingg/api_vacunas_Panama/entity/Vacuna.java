package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vacunas")
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna", nullable = false)
    private Integer id;

    @Column(name = "nombre_vacuna", length = 100)
    private String nombreVacuna;

    @Column(name = "edad_minima")
    private Integer edadMinima;

    @Column(name = "intervalo_dosis_1_2_meses")
    private Double intervaloDosis12Meses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Double getIntervaloDosis12Meses() {
        return intervaloDosis12Meses;
    }

    public void setIntervaloDosis12Meses(Double intervaloDosis12Meses) {
        this.intervaloDosis12Meses = intervaloDosis12Meses;
    }

}