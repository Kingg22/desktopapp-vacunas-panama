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
    @Mapping(target = "updatedAt", source = "updated_at")
    @Mapping(target = "createdAt", source = "created_at")
    @Mapping(target = "contactoTelefono", source = "contacto_telefono")
    @Mapping(target = "contactoNombre", source = "contacto_nombre")
    @Mapping(target = "contactoCorreo", source = "contacto_correo")
    Fabricante toEntity(FabricanteDto fabricanteDto);

    @Mapping(target = "updated_at", source = "updatedAt")
    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "contacto_telefono", source = "contactoTelefono")
    @Mapping(target = "contacto_nombre", source = "contactoNombre")
    @Mapping(target = "contacto_correo", source = "contactoCorreo")
    FabricanteDto toDto(Fabricante fabricante);

}