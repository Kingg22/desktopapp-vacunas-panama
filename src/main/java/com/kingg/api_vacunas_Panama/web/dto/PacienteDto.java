package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Paciente}
 */
public record PacienteDto(
        @Pattern(regexp = "^((RN(\\d{1,2}?)?-)?(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?))-(\\d{1,4})-(\\d{1,6})$|^NI-(\\d*)$|^[A-Z0-9]{5,20}$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "El formato de la cédula u alias no es válido") @NotBlank(message = "La cédula es obligatoria") String cedula,
        @NotBlank(message = "El nombre es obligatorio") String nombrePaciente,
        @NotBlank(message = "Los apellidos son obligatorios") String apellido1Paciente,
        @NotBlank(message = "Los apellidos son obligatorios") String apellido2Paciente,
        @PastOrPresent(message = "La fecha de nacimiento no puede ser futura") LocalDateTime fechaNacimiento,
        @PositiveOrZero(message = "La edad debe ser mayor a 0. Tip: Usar null") Integer edadCalculada,
        @Pattern(regexp = "^[MF]$", message = "El sexo solo puede ser M o F") Character sexo, String telefonoPaciente,
        @Email(message = "El email debe ser válido") String correoPaciente,
        @NotEmpty DireccionDto idDireccion) implements Serializable {
}