package com.kingg.api_vacunas_panama.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.entity.Usuario}
 */
public record UsuarioDto(Integer id,
                         @Pattern(regexp = "^((RN(\\d{1,2}?)?-)?(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?))-(\\d{1,4})-(\\d{1,6})$|^NI-(\\d*)$|^[A-Z0-9]{5,20}$",
                                 flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                                 message = "El formato de la cédula no es válido")
                         @NotBlank(message = "La cédula es obligatoria")
                         String cedula,
                         String username,
                         @Email(message = "El Email debe ser válido") String correoElectronicoUsuario,
                         @Size(min = 8, max = 20, message = "La contraseña debe ser entre 8 y 20 caracteres") String clave,
                         @PastOrPresent(message = "La fecha de nacimiento no puede ser futura")
                         @NotNull(message = "La fecha de nacimiento es obligatoria")
                         LocalDateTime fechaNacimiento,
                         LocalDateTime createdAt, LocalDateTime lastUsed,
                         @NotNull(message = "Debe crear una instancia de roles") @Valid Set<RolDto> roles,
                         Boolean disabled) implements Serializable {
}