package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import com.kingg.api_vacunas_panama.web.dto.SedeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = DireccionMapper.class)
public interface SedeMapper {
    @Mapping(target = "sedesInventarios", ignore = true)
    @Mapping(target = "doctores", ignore = true)
    @Mapping(target = "dosis", ignore = true)
    Sede toEntity(SedeDto sedeDto);

    SedeDto toDto(Sede sede);

}