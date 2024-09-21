package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kingg.api_vacunas_panama.web.dto.ViewPacienteVacunaEnfermedadDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes", indexes = {
        @Index(name = "ix_pacientes_nombre_apellido", columnList = "nombre_paciente, apellido1_paciente, apellido2_paciente"),
        @Index(name = "ix_pacientes_correo", columnList = "correo_paciente", unique = true),
        @Index(name = "ix_pacientes_telefono", columnList = "telefono_paciente", unique = true)
})
@NoArgsConstructor
@Getter
@Setter
@NamedNativeQuery(name = "view_paciente_vacuna_enfermedad", query = "SELECT v.[Nombre vacuna] AS vacuna, " +
        "v.[Número de dosis] AS numero_dosis, " +
        "v.[Enfermedad previene] AS enfermedad_previene, " +
        "v.[Edad mínima recomendada en meses] AS edad_min_recomendada_meses, " +
        "v.[Fecha de aplicación] AS fecha_aplicacion, " +
        "v.[Intervalo recomendado entre dosis 1 y 2 en meses] AS intervalo_recomendado_dosis_meses, " +
        "v.[Sede] AS sede, " +
        "v.[Dependencia] AS dependencia " +
        "FROM view_pacientes_vacunas_enfermedades v WHERE v.Cédula = :cedula",
        resultSetMapping = "view_vacuna_enfermedad"
)
@SqlResultSetMapping(name = "view_vacuna_enfermedad", classes = @ConstructorResult(
        targetClass = ViewPacienteVacunaEnfermedadDto.class,
        columns = {
                @ColumnResult(name = "vacuna", type = String.class),
                @ColumnResult(name = "numero_dosis", type = String.class),
                @ColumnResult(name = "enfermedad_previene", type = String.class),
                @ColumnResult(name = "edad_min_recomendada_meses", type = Short.class),
                @ColumnResult(name = "fecha_aplicacion", type = LocalDateTime.class),
                @ColumnResult(name = "intervalo_recomendado_dosis_meses", type = Double.class),
                @ColumnResult(name = "sede", type = String.class),
                @ColumnResult(name = "dependencia", type = String.class)
        }
))
public class Paciente {
    @Id
    @Size(max = 20)
    @Nationalized
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "nombre_paciente", nullable = false, length = 50)
    private String nombrePaciente;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "apellido1_paciente", nullable = false, length = 50)
    private String apellido1Paciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "apellido2_paciente", length = 50)
    private String apellido2Paciente;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "edad_calculada")
    private Short edadCalculada;

    @NotNull
    @Column(name = "sexo", nullable = false)
    private Character sexo;

    @Size(max = 15)
    @Nationalized
    @Column(name = "telefono_paciente", length = 15)
    private String telefonoPaciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "correo_paciente", length = 50)
    private String correoPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "pacientes")
    @JsonBackReference
    private Set<Dosis> dosis = new LinkedHashSet<>();

    public Paciente(String cedula, String nombrePaciente, String apellido1Paciente, LocalDateTime fechaNacimiento, Character sexo) {
        this.cedula = cedula;
        this.nombrePaciente = nombrePaciente;
        this.apellido1Paciente = apellido1Paciente;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

}