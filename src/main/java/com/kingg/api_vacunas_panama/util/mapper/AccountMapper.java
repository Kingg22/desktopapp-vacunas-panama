package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {
    @Mapping(target = "updatedAt", source = "updated_at")
    @Mapping(target = "rolesPermisos", ignore = true)
    @Mapping(target = "createdAt", source = "created_at")
    @Mapping(target = "roles", ignore = true)
    Permiso permisoDtoToPermiso(PermisoDto permisoDto);

    @Mapping(target = "updated_at", source = "updatedAt")
    @Mapping(target = "created_at", source = "createdAt")
    PermisoDto permisoToDto(Permiso permiso);

    @Mapping(target = "usuariosRoles", ignore = true)
    @Mapping(target = "updatedAt", source = "updated_at")
    @Mapping(target = "rolesPermisos", ignore = true)
    @Mapping(target = "createdAt", source = "created_at")
    @Mapping(target = "usuarios", ignore = true)
    Rol rolDtoToRol(RolDto rolDto);

    @Mapping(target = "updated_at", source = "updatedAt")
    @Mapping(target = "created_at", source = "createdAt")
    RolDto rolToDto(Rol rol);

    @Mapping(target = "pasaporte", ignore = true)
    @Mapping(target = "licencia_fabricante", ignore = true)
    @Mapping(target = "cedula", ignore = true)
    @Mapping(target = "last_used", source = "lastUsed")
    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "password", source = "clave")
    UsuarioDto usuarioToDto(Usuario usuario);

    List<RolDto> rolListToDtoList(List<Rol> roles);

    List<PermisoDto> permisoListToDtoList(List<Permiso> permisos);
}
