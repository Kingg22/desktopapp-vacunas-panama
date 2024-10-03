package com.kingg.api_vacunas_panama.persistence.entity;

import com.kingg.api_vacunas_panama.util.DependenciaType;
import com.kingg.api_vacunas_panama.util.EstadoEntidadType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "entidades", indexes = {
        @Index(name = "ix_entidades_correo", columnList = "correo", unique = true),
        @Index(name = "ix_entidades_telefono", columnList = "telefono", unique = true)
})
public abstract class Entidad {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 254)
    @Column(name = "correo", length = 254)
    private String correo;

    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    private String telefono;

    @Size(max = 13)
    @Nationalized
    @Column(name = "dependencia", length = 13)
    private String dependencia;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Transient
    private EstadoEntidadType estadoEnum;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direccion", nullable = false)
    private Direccion direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public void setEstado(EstadoEntidadType estado) {
        this.estado = estado.name();
    }

    public void setDependencia(DependenciaType dependencia) {
        this.dependencia = dependencia.name();
    }

    public boolean getEstadoEnum() {
        if (this.estado == null) {
            return false;
        }
        try {
            this.estadoEnum = EstadoEntidadType.valueOf(estado.toUpperCase());
            return estadoEnum.isDisabled();
        } catch (IllegalArgumentException argumentException) {
            return false;
        }
    }

}