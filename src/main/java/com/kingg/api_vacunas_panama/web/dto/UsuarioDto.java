package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Usuario}
 */
public record UsuarioDto(
        @Pattern(regexp = "^((RN(\\d{1,2}?)?-)?(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?))-(\\d{1,4})-(\\d{1,6})$|^NI-(\\d*)$|^[A-Z0-9]{5,20}$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "El formato de la cédula no es válido")
        @NotBlank(message = "La cédula es obligatoria")
        String cedula,
        String username,
        @Email(message = "El Email debe ser válido") String email,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Size(min = 8, max = 70, message = "La contraseña no es válida") String password,
        @PastOrPresent(message = "La fecha de nacimiento no puede ser futura")
        @NotNull(message = "La fecha de nacimiento es obligatoria")
        LocalDateTime fecha_nacimiento_usuario,
        LocalDateTime created_at, LocalDateTime last_used,
        @NotNull(message = "Los roles no puede ser null") @Valid Set<RolDto> roles,
        Boolean disabled) implements Serializable {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "cedula: " + cedula + ",username: " + username + ", email: " + email + ", fecha_nacimiento_usuario: " + fecha_nacimiento_usuario + ", " +
                "created_at: " + created_at + ", last_used: " + last_used + ", roles: [" + roles.toString() + "], disabled: " + disabled + ")";
    }
}