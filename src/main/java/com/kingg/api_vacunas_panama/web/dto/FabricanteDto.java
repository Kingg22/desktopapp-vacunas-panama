package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Fabricante;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Fabricante}
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FabricanteDto extends EntidadDto implements Serializable {
    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "^.+/DNFD$",
            flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
            message = "La licencia_fabricante no es válida")
    String licencia;
    @Size(max = 100)
    String contacto_nombre;
    @Size(max = 254)
    @Email
    String contacto_correo;
    @Size(max = 15)
    @Pattern(regexp = "^\\+\\d{1,14}$",
            flags = {Pattern.Flag.MULTILINE},
            message = "El formato del teléfono no es válido")
    String contacto_telefono;
    @NotNull
    @PastOrPresent
    LocalDateTime created_at;
    @PastOrPresent
    LocalDateTime updated_at;
}