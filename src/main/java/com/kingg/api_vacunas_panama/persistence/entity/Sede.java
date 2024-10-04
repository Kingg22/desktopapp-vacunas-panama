package com.kingg.api_vacunas_panama.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "sedes", indexes = {
        @Index(name = "ix_sedes_region_dependencia", columnList = "region")
})
public class Sede extends Entidad {
    @Size(max = 50)
    @Nationalized
    @Column(name = "region", length = 50)
    private String region;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "idSede")
    private Set<Dosis> dosis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sede")
    private Set<Doctor> doctores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sede")
    private Set<SedesInventario> sedesInventarios = new LinkedHashSet<>();

}