package com.kingg.api_vacunas_Panama.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "sedes")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede", nullable = false)
    private Integer id;

    @Column(name = "nombre_sede", nullable = false, length = 100)
    private String nombreSede;

    @Column(name = "correo_electronico_sede", length = 50)
    private String correoElectronicoSede;

    @Column(name = "telefono_sede", length = 15)
    private String telefonoSede;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "dependencia_sede", nullable = false, length = 13)
    private String dependenciaSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getCorreoElectronicoSede() {
        return correoElectronicoSede;
    }

    public void setCorreoElectronicoSede(String correoElectronicoSede) {
        this.correoElectronicoSede = correoElectronicoSede;
    }

    public String getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(String telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDependenciaSede() {
        return dependenciaSede;
    }

    public void setDependenciaSede(String dependenciaSede) {
        this.dependenciaSede = dependenciaSede;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

}