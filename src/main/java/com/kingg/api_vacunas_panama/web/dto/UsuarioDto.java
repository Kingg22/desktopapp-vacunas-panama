package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link Usuario}
 */
public record UsuarioDto(
        UUID id,
        String username,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Size(min = 8, max = 70, message = "La contraseña no es válida") String password,
        LocalDateTime created_at, LocalDateTime last_used,
        @NotEmpty(message = "Los roles no puede estar vacíos") @Valid Set<RolDto> roles,
        @Nullable
        @Size(max = 15)
        @Pattern(regexp = "^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "El formato de la cédula no es válido")
        String cedula,
        @Nullable
        @Size(max = 20)
        @Pattern(regexp = "^[A-Z0-9]{5,20}$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "El formato del pasaporte no es válido")
        String pasaporte,
        @Nullable
        @Size(max = 50)
        @Pattern(regexp = "^.+/DNFD$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "La licencia_fabricante no es válida")
        String licencia_fabricante) implements Serializable {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "id: " + id +
                ", username: " + username + ", created_at: " + created_at + ", last_used: " + last_used +
                ", roles: [" + roles.toString() + "]" + ", cedula: " + cedula + ", pasaporte: " + pasaporte +
                ", licencia_fabricante: " + licencia_fabricante + ")";
    }
}