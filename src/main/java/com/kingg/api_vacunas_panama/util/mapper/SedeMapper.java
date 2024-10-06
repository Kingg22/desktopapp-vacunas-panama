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
    @Mapping(target = "updatedAt", source = "updated_at")
    @Mapping(target = "dosis", ignore = true)
    @Mapping(target = "createdAt", source = "created_at")
    Sede toEntity(SedeDto sedeDto);

    @Mapping(target = "updated_at", source = "updatedAt")
    @Mapping(target = "created_at", source = "createdAt")
    SedeDto toDto(Sede sede);

}