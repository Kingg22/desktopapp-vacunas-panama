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
@Table(name = "view_pacientes_usuarios")
public class ViewPacientesUsuario {
    @Id
    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "\"Cédula\"", nullable = false, length = 20)
    private String cedula;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "\"Apellido 1\"", nullable = false, length = 50)
    private String apellido1;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Apellido 2\"", length = 50)
    private String apellido2;

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
    @Column(name = "\"Teléfono\"", length = 15)
    private String telefono;

    @Size(max = 50)
    @Nationalized
    @Column(name = "\"Correo electrónico paciente\"", length = 50)
    private String correoPaciente;

    @Size(max = 150)
    @Column(name = "\"Dirección residencia actual\"", length = 150)
    private String direccionResidencial;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Distrito", length = 100)
    private String distrito;

    @Size(max = 30)
    @Nationalized
    @Column(name = "Provincia", length = 30)
    private String provincia;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Usuario", length = 50)
    private String usuario;

    @Size(max = 254)
    @Nationalized
    @Column(name = "\"Correo electrónico usuario\"", length = 254)
    private String correoUsuario;

    @Column(name = "\"Fecha de nacimiento usuario\"")
    private LocalDateTime fechaDeNacimientoUsuario;

}