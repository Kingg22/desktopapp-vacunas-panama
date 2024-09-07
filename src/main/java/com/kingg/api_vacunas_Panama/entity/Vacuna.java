package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "vacunas", indexes = {
        @Index(name = "ix_vacunas_nombre", columnList = "nombre_vacuna")
})
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "nombre_vacuna", length = 100)
    private String nombreVacuna;

    @Column(name = "edad_minima")
    private Integer edadMinima;

    @Column(name = "intervalo_dosis_1_2_meses")
    private Double intervalo2DosisMeses;

    @OneToMany(mappedBy = "idVacuna")
    private Set<Dosis> dosis = new LinkedHashSet<>();

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

    public Double getIntervalo2DosisMeses() {
        return intervalo2DosisMeses;
    }

    public void setIntervalo2DosisMeses(Double intervalo2DosisMeses) {
        this.intervalo2DosisMeses = intervalo2DosisMeses;
    }

    public Set<Dosis> getDosis() {
        return dosis;
    }

    public void setDosis(Set<Dosis> dosis) {
        this.dosis = dosis;
    }

}