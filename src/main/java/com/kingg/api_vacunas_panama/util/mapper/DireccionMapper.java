package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import com.kingg.api_vacunas_panama.persistence.entity.Distrito;
import com.kingg.api_vacunas_panama.persistence.entity.Provincia;
import com.kingg.api_vacunas_panama.web.dto.DireccionDto;
import com.kingg.api_vacunas_panama.web.dto.DistritoDto;
import com.kingg.api_vacunas_panama.web.dto.ProvinciaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DireccionMapper {
    @Mapping(target = "distritos", ignore = true)
    Provincia provinciaDtoToEntity(ProvinciaDto provinciaDto);

    ProvinciaDto provinciaToDto(Provincia provincia);

    DistritoDto distritoToDto(Distrito distrito);

    @Mapping(target = "direcciones", ignore = true)
    Distrito distritoDtoToEntity(DistritoDto distritoDto);

    @Mapping(target = "sedes", ignore = true)
    @Mapping(target = "pacientes", ignore = true)
    Direccion direccionDtoToEntity(DireccionDto direccionDto);

    DireccionDto direccionToDto(Direccion direccion);

    List<DistritoDto> distritoListToDto(List<Distrito> distritos);

    List<ProvinciaDto> provinciaListToDto(List<Provincia> provinciaList);
}
