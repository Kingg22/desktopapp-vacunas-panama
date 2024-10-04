package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import com.kingg.api_vacunas_panama.util.NumDosisEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link Vacuna}
 */
public record VacunaDto(UUID id, @NotNull @Size(max = 100) @NotBlank String nombre, Short edad_minima_meses,
                        Float intervalo_dosis_meses, NumDosisEnum dosis_maxima, @PastOrPresent LocalDateTime created_at,
                        @PastOrPresent LocalDateTime updated_at) implements Serializable {
}