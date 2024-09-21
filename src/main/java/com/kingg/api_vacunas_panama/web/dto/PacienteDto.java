package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Paciente}
 */
public record PacienteDto(
        @Pattern(regexp = "^((RN(\\d{1,2}?)?-)?(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?))-(\\d{1,4})-(\\d{1,6})$|^NI-(\\d*)$|^[A-Z0-9]{5,20}$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "El formato de la cédula u alias no es válido") @NotBlank(message = "La cédula es obligatoria")
        String cedula,
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        @NotBlank(message = "Los apellidos son obligatorios") String apellido1,
        @NotBlank(message = "Los apellidos son obligatorios") String apellido2,
        @PastOrPresent(message = "La fecha de nacimiento no puede ser futura") LocalDateTime fecha_nacimiento,
        @PositiveOrZero(message = "La edad debe ser mayor a 0. Tip: Usar null") Integer edad,
        @Pattern(regexp = "^[MF]$", message = "El sexo solo puede ser M o F") Character sexo, String telefono,
        @Email(message = "El email debe ser válido") String email,
        @NotNull(message = "La dirección no puede ser null") @Valid DireccionDto direccion,
        @NotNull @Future(message = "La fecha de creación no puede ser futura") LocalDateTime createdAt) implements Serializable {
}