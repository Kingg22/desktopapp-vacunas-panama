package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link Sede}
 */
public record SedeDto(UUID id, @NotNull @Size(max = 100) @NotBlank String nombre, @Size(max = 254) String correo,
                      @Size(max = 15) String telefono, @Size(max = 13) @NotBlank String dependencia,
                      @NotNull @Size(max = 50) String estado, @NotNull DireccionDto direccion,
                      @Size(max = 50) String region, @PastOrPresent LocalDateTime created_at,
                      @PastOrPresent LocalDateTime updated_at) implements Serializable {
}