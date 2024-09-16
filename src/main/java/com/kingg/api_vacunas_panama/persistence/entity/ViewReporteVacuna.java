package com.kingg.api_vacunas_panama.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_reporte_vacunas")
public class ViewReporteVacuna {
    @Id
    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "cedula_paciente", nullable = false, length = 20)
    private String cedulaPaciente;

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
    @Column(name = "fecha_nacimiento_paciente", nullable = false)
    private LocalDateTime fechaNacimientoPaciente;

    @NotNull
    @Column(name = "sexo_paciente", nullable = false)
    private Character sexoPaciente;

    @Size(max = 15)
    @Nationalized
    @Column(name = "telefono_paciente", length = 15)
    private String telefonoPaciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "correo_paciente", length = 50)
    private String correoPaciente;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_vacuna", nullable = false, length = 100)
    private String nombreVacuna;

    @NotNull
    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDateTime fechaAplicacion;

    @Size(max = 2)
    @NotNull
    @Column(name = "numero_dosis", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String numeroDosis;

    @Column(name = "intervalo_dosis_recomendado_en_meses")
    private Float intervaloDosisRecomendadoEnMeses;

    @Column(name = "intervalo_real_en_dias")
    private Integer intervaloRealEnDias;

    @Column(name = "edad_minima_recomendada_en_meses")
    private Short edadMinimaRecomendadaEnMeses;

    @NotNull
    @Column(name = "id_sede", nullable = false)
    private UUID idSede;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "nombre_sede", nullable = false, length = 100)
    private String nombreSede;

    @Size(max = 150)
    @Column(name = "direccion_sede", length = 150)
    private String direccionSede;

    @Size(max = 100)
    @Nationalized
    @Column(name = "distrito", length = 100)
    private String distrito;

    @Size(max = 30)
    @Nationalized
    @Column(name = "provincia", length = 30)
    private String provincia;

}