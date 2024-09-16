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

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_pacientes_completos")
public class ViewPacientesCompleto {
    @Id
    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "\"Cédula paciente\"", nullable = false, length = 20)
    private String cedulaPaciente;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "\"Nombre paciente\"", nullable = false, length = 50)
    private String nombrePaciente;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "\"Apellido 1 paciente\"", nullable = false, length = 50)
    private String apellido1Paciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Apellido 2 paciente\"", length = 50)
    private String apellido2Paciente;

    @NotNull
    @Column(name = "\"Fecha de nacimiento paciente\"", nullable = false)
    private LocalDateTime fechaDeNacimientoPaciente;

    @Column(name = "Edad")
    private Integer edad;

    @NotNull
    @Column(name = "Sexo", nullable = false)
    private Character sexo;

    @Size(max = 15)
    @Nationalized
    @Column(name = "\"Teléfono paciente\"", length = 15)
    private String telefonoPaciente;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Correo electrónico paciente\"", length = 50)
    private String correoPaciente;

    @Size(max = 150)
    @Column(name = "\"Dirección residencial actual paciente\"", length = 150)
    private String direccionPaciente;

    @Size(max = 100)
    @Nationalized
    @Column(name = "\"Distrito paciente\"", length = 100)
    private String distritoPaciente;

    @Size(max = 30)
    @Nationalized
    @Column(name = "\"Provincia paciente\"", length = 30)
    private String provinciaPaciente;

    @Size(max = 100)
    @Nationalized
    @Column(name = "\"Sede vacunado\"", length = 100)
    private String sedeVacunado;

    @Size(max = 150)
    @Column(name = "\"Dirección sede\"", length = 150)
    private String direccionSede;

    @Size(max = 100)
    @Nationalized
    @Column(name = "\"Distrito sede\"", length = 100)
    private String distritoSede;

    @Size(max = 30)
    @Nationalized
    @Column(name = "\"Provincia sede\"", length = 30)
    private String provinciaSede;

    @Size(max = 15)
    @Nationalized
    @Column(name = "\"Teléfono sede\"", length = 15)
    private String telefonoSede;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Región de salud sede\"", length = 50)
    private String regionDeSaludSede;

    @Size(max = 13)
    @Nationalized
    @Column(name = "\"Depedencia sede\"", length = 13)
    private String depedenciaSede;

    @Size(max = 100)
    @Nationalized
    @Column(name = "\"Nombre vacuna\"", length = 100)
    private String nombreVacuna;

    @Column(name = "\"Fecha de aplicación\"")
    private LocalDateTime fechaDeAplicacion;

    @Size(max = 2)
    @Column(name = "\"Número de dosis aplicada\"", length = 2, columnDefinition = "CHAR(2)")
    private String numDeDosisAplicada;

    @Column(name = "\"Intervalo dosis recomendado en meses\"")
    private Float intervaloDosisRecomendadoEnMeses;

    @Column(name = "\"Intervalo real en días\"")
    private Integer intervaloRealEnDias;

    @Column(name = "\"Edad mínima recomendada en meses\"")
    private Short edadMinRecomendadaEnMeses;

    @Size(max = 100)
    @Nationalized
    @Column(name = "\"Enfermedad prevenida\"", length = 100)
    private String enfermedadPrevenida;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Nivel de gravedad enfermedad\"", length = 50)
    private String nivelDeGravedadEnfermedad;

}