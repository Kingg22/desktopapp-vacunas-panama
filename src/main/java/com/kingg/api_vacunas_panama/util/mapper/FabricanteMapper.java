package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Fabricante;
import com.kingg.api_vacunas_panama.web.dto.FabricanteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DireccionMapper.class, AccountMapper.class})
public interface FabricanteMapper {

    @Mapping(target = "vacunas", ignore = true)
    Fabricante toEntity(FabricanteDto fabricanteDto);

    FabricanteDto toDto(Fabricante fabricante);

}