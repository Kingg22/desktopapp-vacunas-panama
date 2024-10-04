package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import com.kingg.api_vacunas_panama.web.dto.SedeDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = DireccionMapper.class)
public interface SedeMapper {
    @Mapping(target = "updatedAt", source = "updated_at")
    @Mapping(target = "dosis", ignore = true)
    @Mapping(target = "createdAt", source = "created_at")
    Sede toEntity(SedeDto sedeDto);

    @Mapping(target = "updated_at", source = "updatedAt")
    @Mapping(target = "created_at", source = "createdAt")
    SedeDto toDto(Sede sede);

    @Mapping(target = "updatedAt", source = "updated_at")
    @Mapping(target = "dosis", ignore = true)
    @Mapping(target = "createdAt", source = "created_at")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Sede partialUpdate(SedeDto sedeDto, @MappingTarget Sede sede);
}