package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import com.kingg.api_vacunas_panama.web.dto.VacunaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VacunaMapper {

    VacunaDto toDto(Vacuna vacuna);

    @Mapping(target = "sedesInventarios", ignore = true)
    @Mapping(target = "dosis", ignore = true)
    Vacuna toEntity(VacunaDto vacunaDto);

}
