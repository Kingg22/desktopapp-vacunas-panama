package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.*;
import com.kingg.api_vacunas_panama.persistence.repository.PermisoRepository;
import com.kingg.api_vacunas_panama.persistence.repository.RolRepository;
import com.kingg.api_vacunas_panama.persistence.repository.UsuarioRepository;
import com.kingg.api_vacunas_panama.util.mapper.AccountMapper;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service for {@link UsuarioManagementService} transaction.
 * Public methods required by {@link Transactional}
 */
@Slf4j
@Service
@RequiredArgsConstructor
class UsuarioTransactionService {
    private final AccountMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PermisoRepository permisoRepository;
    private final RolRepository rolRepository;

    @Transactional
    public Usuario createUser(@NotNull UsuarioDto usuarioDto, @Nullable Persona persona, @Nullable Fabricante fabricante) {
        if (persona != null && fabricante != null) {
            throw new IllegalArgumentException("No se puede crear un usuario sin relacionarse a una persona o fabricante");
        }
        Set<Rol> role = usuarioDto.roles().stream()
                .map(this::convertToRoleExisting)
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .username(usuarioDto.username())
                .clave(passwordEncoder.encode(usuarioDto.password()))
                .createdAt(LocalDateTime.now())
                .roles(role)
                .build();
        if (persona != null) {
            usuario.setPersona(persona);
            persona.setUsuario(usuario);
        }
        if (fabricante != null) {
            usuario.setFabricante(fabricante);
            fabricante.setUsuario(usuario);
        }
        return usuarioRepository.save(usuario);
    }

    PermisoDto createPermiso(PermisoDto permisoDto) {
        return mapper.permisoToDto(permisoRepository.save(mapper.permisoDtoToPermiso(permisoDto)));
    }

    @Transactional
    @Modifying
    public Usuario changePasswordPersonas(Persona persona, String newPassword) {
        Usuario usuario = persona.getUsuario();
        usuario.setClave(passwordEncoder.encode(newPassword));
        return usuarioRepository.save(usuario);
    }

    Rol convertToRoleExisting(RolDto rolDto) {
        return rolRepository.findByNombreOrId(rolDto.nombre(), rolDto.id()).orElse(null);
    }

    Permiso convertToPermisoExisting(PermisoDto permisoDto) {
        return permisoRepository.findByNombreOrId(permisoDto.nombre(), permisoDto.id()).orElse(null);
    }
}
