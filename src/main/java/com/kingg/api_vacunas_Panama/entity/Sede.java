package com.kingg.api_vacunas_panama.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sedes", indexes = {
        @Index(name = "ix_sedes_nombre_region_dependencia", columnList = "nombre_sede, region, dependencia_sede"),
        @Index(name = "uq_sedes_nombre", columnList = "nombre_sede", unique = true),
        @Index(name = "ix_sedes_telefono", columnList = "telefono_sede", unique = true),
        @Index(name = "ix_sedes_email", columnList = "correo_electronico_sede", unique = true)
})
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_sede", nullable = false, length = 100)
    private String nombreSede;

    @Size(max = 50)
    @Nationalized
    @Column(name = "correo_electronico_sede", length = 50)
    private String correoElectronicoSede;

    @Size(max = 15)
    @Nationalized
    @Column(name = "telefono_sede", length = 15)
    private String telefonoSede;

    @Size(max = 50)
    @Nationalized
    @Column(name = "region", length = 50)
    private String region;

    @Size(max = 13)
    @NotNull
    @Nationalized
    @Column(name = "dependencia_sede", nullable = false, length = 13)
    private String dependenciaSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    @OneToMany(mappedBy = "idSede")
    private Set<Dosis> doses = new LinkedHashSet<>();

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

    public Set<Dosis> getDoses() {
        return doses;
    }

    public void setDoses(Set<Dosis> doses) {
        this.doses = doses;
    }

}