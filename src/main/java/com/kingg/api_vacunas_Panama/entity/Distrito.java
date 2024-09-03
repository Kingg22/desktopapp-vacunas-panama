package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "distritos")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito", nullable = false)
    private Integer id;

    @ColumnDefault("'Panama'")
    @Column(name = "distrito", length = 100)
    private String distrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "id_provincia")
    private Provincia idProvincia;

    public Provincia getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Provincia idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}