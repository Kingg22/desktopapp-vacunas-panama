package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "sedes", indexes = {
        @Index(name = "ix_sedes_nombre_region_dependencia", columnList = "nombre_sede, region, dependencia_sede"),
        @Index(name = "uq_sedes_nombre", columnList = "nombre_sede", unique = true),
        @Index(name = "ix_sedes_telefono", columnList = "telefono_sede", unique = true),
        @Index(name = "ix_sedes_email", columnList = "correo_sede", unique = true)
})
@NoArgsConstructor
@Getter
@Setter
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_sede", nullable = false)
    private UUID id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_sede", nullable = false, length = 100)
    private String nombreSede;

    @Size(max = 50)
    @Nationalized
    @Column(name = "correo_sede", length = 50)
    private String correoSede;

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
    @JsonBackReference
    private Set<Dosis> dosis = new LinkedHashSet<>();

}