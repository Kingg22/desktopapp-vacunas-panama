package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * DTO for {@link Sede}
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SedeDto extends EntidadDto {
    String region;
    @Nullable
    @PastOrPresent
    LocalDateTime created_at;
    @PastOrPresent
    LocalDateTime updated_at;
}
