package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.persistence.repository.*;
import com.kingg.api_vacunas_panama.util.ContentResponse;
import com.kingg.api_vacunas_panama.util.FormatCedulaUtil;
import com.kingg.api_vacunas_panama.util.ResponseCode;
import com.kingg.api_vacunas_panama.util.RolesEnum;
import com.kingg.api_vacunas_panama.util.mapper.AccountMapper;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service for {@link Usuario}, {@link Rol} and {@link Permiso}
 * Extends functionality from {@link PersonaService} and {@link FabricanteService}
 * inheriting methods that involve {@link Usuario} in relation to these services.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UsuarioManagementService {
    private final AccountMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PermisoRepository permisoRepository;
    private final RolRepository rolRepository;
    private final PersonaRepository personaRepository;
    private final EntidadRepository entidadRepository;
    private final UsuarioValidationService validationService;

    @Transactional
    public UsuarioDto createUser(UsuarioDto usuarioDto, ContentResponse contentResponse) {
        validationService.validateRegistration(usuarioDto, contentResponse);
        Set<Rol> role = usuarioDto.roles().stream()
                .map(this::convertToRoleExisting)
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .username(usuarioDto.username())
                .clave(passwordEncoder.encode(usuarioDto.password()))
                .createdAt(LocalDateTime.now())
                .roles(role)
                .build();
        return mapper.usuarioToDto(usuarioRepository.save(usuario));
    }

    public RolDto createRol(RolDto rolDto) {
        return mapper.rolToDto(rolRepository.save(mapper.rolDtoToRol(rolDto)));
    }

    public PermisoDto createPermiso(PermisoDto permisoDto) {
        return mapper.permisoToDto(permisoRepository.save(mapper.permisoDtoToPermiso(permisoDto)));
    }

    @Transactional
    @Modifying
    public void changePasswordPersonas(Persona persona, String newPassword, LocalDate birthdate) {
        Usuario usuario = persona.getUsuario();
        if (!persona.getFechaNacimiento().toLocalDate().equals(birthdate)) {
            throw new IllegalArgumentException("La fecha de cumpleaños no coincide");
        }
        if (passwordEncoder.matches(newPassword, usuario.getClave())) {
            throw new IllegalArgumentException("La nueva contraseña no puede ser igual a la contraseña actual");
        }
        usuario.setClave(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario);
    }

    public void validateAuthoritiesRegister(UsuarioDto usuarioDto, ContentResponse contentResponse, Authentication authentication) {
        List<String> authenticatedAuthorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        List<RolesEnum> authenticatedRoles = authenticatedAuthorities.stream()
                .map(RolesEnum::valueOf)
                .toList();

        if (!usuarioDto.roles().stream().allMatch(rolDto -> validationService.canRegisterRole(rolDto, authenticatedRoles))) {
            contentResponse.addError("code", ResponseCode.ROL_HIERARCHY_VIOLATION.toString());
            contentResponse.addError("message", "No puede asignar roles superiores a su rol máximo actual");
        }

        if (!validationService.hasUserManagementPermissions(authenticatedAuthorities)) {
            contentResponse.addError("code", ResponseCode.PERMISSION_DENIED.toString());
            contentResponse.addError("message", "No tienes permisos para registrar a otros usuarios");
        }
    }

    public UsuarioDto getUsuarioDto(String identifier) {
        Usuario usuario = getUsuario(identifier).orElseThrow();
        return mapper.usuarioToDto(usuario);
    }

    public UsuarioDto getUsuarioDto(UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return mapper.usuarioToDto(usuario);
    }

    /**
     * Finds a user based on a given identifier by searching across multiple fields form related tables.
     * <p>
     * Additionally, the user's {@code disabled} status is manually set as part of the result.
     *
     * @param identifier the identifier used to search for the user (e.g. username, email, cedula)
     * @return an {@link Optional} containing the found {@link Usuario} or empty if no user matches the identifier.
     */
    Optional<Usuario> getUsuario(@NotNull String identifier) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(identifier);

        usuarioOpt.ifPresent(usuario -> {
            Optional<Persona> personaOpt = personaRepository.findByUsuario_Id(usuario.getId());
            personaOpt.ifPresent(persona -> usuario.setDisabled(persona.getEstadoEnum()));
        });
        if (usuarioOpt.isEmpty()) {
            String cedula = null;
            String pasaporte = identifier.matches("^[A-Z0-9]{5,20}$") ? identifier : null;
            String correo = identifier.matches("^_@_.__$") ? identifier : null;
            try {
                cedula = FormatCedulaUtil.formatCedula(identifier);
            } catch (IllegalArgumentException argumentException) {
                log.info("identifier no find a usuario is not a cedula");
            }
            usuarioOpt = usuarioRepository.findByCedulaOrPasaporteOrCorreo(cedula, pasaporte, correo);
            usuarioOpt.ifPresent(usuario ->
                    personaRepository.findByUsuario_Id(usuario.getId()).ifPresent(persona -> usuario.setDisabled(persona.getEstadoEnum()))
            );
        }
        if (usuarioOpt.isEmpty()) {
            usuarioOpt = usuarioRepository.findByLicenciaOrCorreo(identifier, identifier);
            usuarioOpt.ifPresent(usuario ->
                    entidadRepository.findByUsuario_Id(usuario.getId()).ifPresent(entidad -> usuario.setDisabled(entidad.getEstadoEnum()))
            );
        }
        return usuarioOpt;
    }

    private Rol convertToRoleExisting(RolDto rolDto) {
        return rolRepository.findByNombreOrId(rolDto.nombre(), rolDto.id()).orElse(null);
    }

    private Permiso convertToPermisoExisting(PermisoDto permisoDto) {
        return permisoRepository.findByNombreOrId(permisoDto.nombre(), permisoDto.id()).orElseThrow();
    }

}
