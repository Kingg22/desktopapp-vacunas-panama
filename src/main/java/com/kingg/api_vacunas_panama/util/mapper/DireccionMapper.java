package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import com.kingg.api_vacunas_panama.persistence.entity.Distrito;
import com.kingg.api_vacunas_panama.service.DireccionService;
import com.kingg.api_vacunas_panama.web.dto.DireccionDto;
import com.kingg.api_vacunas_panama.web.dto.DistritoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = DireccionService.class)
public interface DireccionMapper {

    @Mapping(target = "idDistrito", source = "distrito.id")
    @Mapping(target = "sedes", ignore = true)
    @Mapping(target = "pacientes", ignore = true)
    Direccion direccionDtoToDireccion(DireccionDto direccionDto);

    @Mapping(target = "provincia", source = "idProvincia.nombreProvincia")
    @Mapping(target = "nombre", source = "nombreDistrito")
    DistritoDto distritoToDto(Distrito distrito);

    @Mapping(target = "nombreDistrito", source = "nombre")
    @Mapping(target = "idProvincia", ignore = true)
    @Mapping(target = "direcciones", ignore = true)
    Distrito distritoDtoToDistrito(DistritoDto distritoDto);

    DireccionDto direccionToDto(Direccion direccion);

}
