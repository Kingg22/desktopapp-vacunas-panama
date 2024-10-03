package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Paciente}
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PacienteDto extends PersonaDto implements Serializable {
    @Size(max = 255)
    @Pattern(regexp = "^(RN(\\\\d{1,2}?)?)-(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\\\d{1,4})-(\\\\d{1,6})$|^NI-.+$",
            flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
            message = "El formato de id temporal no es válido")
    String identificacion_temporal;
    @NotNull
    @PastOrPresent
    LocalDateTime created_at;
    @PastOrPresent
    LocalDateTime updated_at;
}