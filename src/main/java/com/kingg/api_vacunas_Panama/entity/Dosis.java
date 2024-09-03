package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "dosis")
public class Dosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dosis", nullable = false)
    private Integer id;

    @Column(name = "fecha_aplicacion")
    private LocalDateTime fechaAplicacion;

    @Column(name = "numero_dosis", nullable = false, columnDefinition = "CHAR(2)")
    private String numeroDosis;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vacuna", nullable = false)
    private Vacuna idVacuna;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("1")
    @JoinColumn(name = "id_sede")
    private Sede idSede;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDateTime fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(String numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public Vacuna getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Vacuna idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

}