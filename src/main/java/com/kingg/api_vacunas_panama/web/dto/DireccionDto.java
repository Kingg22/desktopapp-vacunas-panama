package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link Direccion}
 */
@Validated
public record DireccionDto(UUID id,
                           @Size(max = 150, message = "La indicaciones de la dirección es muy larga, no incluya la provincia y distrito")
                           @JsonProperty(defaultValue = "Por registrar")
                           String direccion,
                           @Valid DistritoDto distrito,
                           @Nullable @PastOrPresent LocalDateTime created_at,
                           @PastOrPresent LocalDateTime updated_at) implements Serializable {
}