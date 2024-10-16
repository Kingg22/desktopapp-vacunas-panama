package com.kingg.api_vacunas_panama.persistence.entity;

import com.kingg.api_vacunas_panama.util.NumDosisEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "dosis")
public class Dosis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDateTime fechaAplicacion;

    @Size(max = 2)
    @NotNull
    @Column(name = "numero_dosis", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private NumDosisEnum numeroDosis;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vacuna", nullable = false)
    private Vacuna idVacuna;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sede", nullable = false)
    private Sede idSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor")
    private Doctor idDoctor;

    @Size(max = 50)
    @Nationalized
    @Column(name = "lote", length = 50)
    private String lote;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "dosis")
    private Set<PacientesDosis> pacientesDosis = new LinkedHashSet<>();

}