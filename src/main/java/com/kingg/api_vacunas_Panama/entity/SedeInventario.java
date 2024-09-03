package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;


@Entity
@Table(name = "sedes_inventarios")
public class SedeInventario {
    @EmbeddedId
    private SedeInventarioId id;

    @MapsId("idSede")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("1")
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede idSede;

    @MapsId("idVacuna")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vacuna", nullable = false)
    private Vacuna idVacuna;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_lote_sede", nullable = false)
    private LocalDateTime fechaLoteSede;

    @Column(name = "lote_sede", nullable = false, length = 10)
    private String loteSede;

    public SedeInventarioId getId() {
        return id;
    }

    public void setId(SedeInventarioId id) {
        this.id = id;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    public Vacuna getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Vacuna idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaLoteSede() {
        return fechaLoteSede;
    }

    public void setFechaLoteSede(LocalDateTime fechaLoteSede) {
        this.fechaLoteSede = fechaLoteSede;
    }

    public String getLoteSede() {
        return loteSede;
    }

    public void setLoteSede(String loteSede) {
        this.loteSede = loteSede;
    }

}