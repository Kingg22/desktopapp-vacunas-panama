package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "direcciones")
@NoArgsConstructor
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 150)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distrito")
    private Distrito distrito;

    @OneToMany(mappedBy = "direccion")
    @JsonBackReference
    private Set<Paciente> pacientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "direccion")
    @JsonBackReference
    private Set<Sede> sedes = new LinkedHashSet<>();

    public Direccion(String direccion, Distrito distrito) {
        this.direccion = direccion;
        this.distrito = distrito;
    }

}