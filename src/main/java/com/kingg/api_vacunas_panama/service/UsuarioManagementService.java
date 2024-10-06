package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.*;
import com.kingg.api_vacunas_panama.persistence.repository.PermisoRepository;
import com.kingg.api_vacunas_panama.persistence.repository.RolRepository;
import com.kingg.api_vacunas_panama.persistence.repository.UsuarioRepository;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.FormatterUtil;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.util.RolesEnum;
import com.kingg.api_vacunas_panama.util.mapper.AccountMapper;
import com.kingg.api_vacunas_panama.util.mapper.FabricanteMapper;
import com.kingg.api_vacunas_panama.util.mapper.PersonaMapper;
import com.kingg.api_vacunas_panama.web.dto.RestoreDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service for {@link Usuario}, {@link Rol} and {@link Permiso}
 * Extends functionality from {@link PersonaService} and {@link FabricanteService}
 * inheriting methods that involve {@link Usuario} in relation to these services.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioManagementService {
    private final AccountMapper mapper;
    private final FabricanteMapper fabricanteMapper;
    private final PersonaMapper personaMapper;
    private final UsuarioRepository usuarioRepository;
    private final PermisoRepository permisoRepository;
    private final RolRepository rolRepository;
    private final TokenService tokenService;
    private final PersonaService personaService;
    private final FabricanteService fabricanteService;
    private final UsuarioValidationService validationService;
    private final UsuarioTransactionService transactionService;

    public void validateAuthoritiesRegister(UsuarioDto usuarioDto, IApiResponse<?, Object> apiResponse, Authentication authentication) {
        List<String> authenticatedAuthorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        try {
            List<RolesEnum> authenticatedRoles = authenticatedAuthorities.stream().map(RolesEnum::valueOf).toList();
            if (!usuarioDto.roles().stream().allMatch((rolDto) -> {
                return this.validationService.canRegisterRole(rolDto, authenticatedRoles);
            })) {
                apiResponse.addError(ApiResponseCode.ROL_HIERARCHY_VIOLATION, "No puede asignar roles superiores a su rol máximo actual");
            }
        } catch (IllegalArgumentException var6) {
            log.debug("Argument exception by RolesEnum: {}", var6.getMessage());
            apiResponse.addWarning(ApiResponseCode.API_UPDATE_UNSUPPORTED, "Roles creados recientemente no son soportados para registrarse");
        }

        if (!this.validationService.hasUserManagementPermissions(authenticatedAuthorities)) {
            apiResponse.addError(ApiResponseCode.PERMISSION_DENIED, "No tienes permisos para registrar a otros usuarios");
        }

    }

    public void createUser(UsuarioDto usuarioDto, IApiResponse<String, Object> response) {
        if (usuarioDto.roles().stream().anyMatch(rolDto -> rolDto.permisos() != null && !rolDto.permisos().isEmpty())) {
            response.addWarning(ApiResponseCode.INFORMATION_IGNORED, "Los permisos de los roles son ignorados en el registro. Para crear o relacionar nuevos permisos a un rol debe utilizar otra opción");
        }

        if (usuarioDto.roles().stream().anyMatch(rolDto -> rolDto.nombre() != null && !rolDto.nombre().isEmpty())) {
            response.addWarning(ApiResponseCode.NON_IDEMPOTENCE, "Utilice ID al realizar peticiones");
        }

        Object personaFabricante = this.validationService.validateRegistration(usuarioDto, response);
        if (!response.hasErrors()) {
            assert personaFabricante != null;

            UUID idPersona = null;
            UUID idFabricante = null;
            Usuario user;

            switch (personaFabricante) {
                case Persona persona -> {
                    user = transactionService.createUser(usuarioDto, persona, null);
                    idPersona = persona.getId();
                    response.addData("person", personaMapper.toDto(persona));
                }
                case Fabricante fabricante -> {
                    user = transactionService.createUser(usuarioDto, null, fabricante);
                    idFabricante = fabricante.getId();
                    response.addData("fabricante", fabricanteMapper.toDto(fabricante));
                }
                default -> {
                    response.addError(ApiResponseCode.API_UPDATE_UNSUPPORTED, "Ha ocurrido un error en la validación");
                    response.addStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.addStatus(ApiResponseCode.VALIDATION_FAILED.toString());
                    return;
                }
            }

            response.addData("token", this.tokenService.generateToken(this.mapper.usuarioToDto(user), idPersona, idFabricante));
            response.addStatusCode(HttpStatus.CREATED);
            response.addStatus("Successful user creation");
        } else {
            response.addStatusCode(HttpStatus.BAD_REQUEST);
            response.addStatus(ApiResponseCode.VALIDATION_FAILED.toString());
        }

    }

    public void changePasswordPersona(IApiResponse<String, Object> apiResponse, RestoreDto restoreDto) {
        Optional<Persona> opPersona = this.personaService.getPersona(restoreDto.username());
        opPersona.ifPresentOrElse(persona -> {
            this.validationService.validateChangePasswordPersona(persona, restoreDto.new_password(), restoreDto.fecha_nacimiento(), apiResponse);
            if (apiResponse.hasErrors()) {
                apiResponse.addStatusCode(HttpStatus.BAD_REQUEST);
                apiResponse.addStatus("Failed to change password");
            } else {
                this.transactionService.changePasswordPersonas(persona, restoreDto.new_password());
                apiResponse.addStatusCode(HttpStatus.OK);
                apiResponse.addStatus("Password restored successfully");
            }
        }, () -> {
            apiResponse.addStatusCode(HttpStatus.NOT_FOUND);
            apiResponse.addStatus("Not found person with identifier");
            apiResponse.addError(ApiResponseCode.NOT_FOUND, "La persona con la identificación dada no fue encontrada");
        });
    }

    public void setLoginResponse(UUID idUser, IApiResponse<?, Object> apiResponse) {
        UsuarioDto user = this.getUsuarioDto(idUser);
        Optional<UUID> idPersona = this.personaService.getPersonaByUserID(idUser).map(persona -> {
            apiResponse.addData("persona", this.personaMapper.toDto(persona));
            return persona.getId();
        });
        Optional<UUID> idFabricante = this.fabricanteService.getFabricanteByUserID(idUser).map(fabricante -> {
            apiResponse.addData("fabricante", this.fabricanteMapper.toDto(fabricante));
            return fabricante.getId();
        });
        apiResponse.addData("token", this.tokenService.generateToken(user, idPersona.orElse(null), idFabricante.orElse(null)));
        apiResponse.addStatusCode(HttpStatus.OK);
        apiResponse.addStatus("Login successful");
    }

    public void getProfile(UUID idUser, IApiResponse<?, Object> apiResponse) {
        this.personaService.getPersonaByUserID(idUser).ifPresent(persona ->
                apiResponse.addData("persona", this.personaMapper.toDto(persona))
        );
        this.fabricanteService.getFabricanteByUserID(idUser).ifPresent(fabricante ->
                apiResponse.addData("fabricante", this.fabricanteMapper.toDto(fabricante))
        );
        apiResponse.addStatusCode(HttpStatus.OK);
    }

    public void getRoles(IApiResponse<?, Object> response) {
        response.addData("roles", rolRepository.findAllIdNombre());
    }

    public void getPermisos(IApiResponse<?, Object> response) {
        response.addData("permisos", permisoRepository.findAllIdNombre());
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
        log.debug("Searching by username: {}", identifier);
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findByUsername(identifier);
        usuarioOpt.ifPresent(usuario -> {
            Optional<Persona> personaOpt = this.personaService.getPersonaByUserID(usuario.getId());
            personaOpt.ifPresent(persona -> usuario.setDisabled(persona.getDisabled()));
            log.debug("Found user: {}, with username", usuario.getId());
        });
        if (usuarioOpt.isEmpty()) {
            String[] result = FormatterUtil.formatToSearch(identifier);
            log.debug("Searching by cedula: {}, pasaporte: {}, correo: {}", result[0], result[1], result[2]);
            usuarioOpt = this.usuarioRepository.findByCedulaOrPasaporteOrCorreo(result[0], result[1], result[2]);
            usuarioOpt.ifPresent(usuario -> {
                this.personaService.getPersonaByUserID(usuario.getId()).ifPresent(persona -> usuario.setDisabled(persona.getDisabled()));
                log.debug("Found user: {}, with credentials of Persona", usuario.getId());
            });
        }

        if (usuarioOpt.isEmpty()) {
            log.debug("Searching by licencia or correo Fabricante");
            usuarioOpt = this.usuarioRepository.findByLicenciaOrCorreo(identifier, identifier);
            usuarioOpt.ifPresent(usuario -> {
                this.fabricanteService.getFabricanteByUserID(usuario.getId()).ifPresent(fabricante -> usuario.setDisabled(fabricante.getDisabled()));
                log.debug("Found user: {}, with credentials of Fabricante", usuario.getId());
            });
        }

        return usuarioOpt;
    }

}
