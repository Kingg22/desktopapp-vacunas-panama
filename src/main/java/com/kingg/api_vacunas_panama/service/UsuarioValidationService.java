package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Fabricante;
import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.persistence.repository.UsuarioRepository;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.util.RolesEnum;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Service for {@link UsuarioManagementService} validations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
class UsuarioValidationService {
    private final PasswordEncoder passwordEncoder;
    private final CompromisedPasswordChecker compromisedPasswordChecker;
    private final PersonaService personaService;
    private final FabricanteService fabricanteService;
    private final UsuarioRepository usuarioRepository;

    Object validateRegistration(UsuarioDto usuarioDto, IApiResponse<String, Object> apiResponse) {
        if (this.isUsernameRegistered(usuarioDto.username())) {
            apiResponse.addError(ApiResponseCode.ALREADY_TAKEN, "username", "El nombre de usuario ya está en uso");
        }

        if (this.compromisedPasswordChecker.check(usuarioDto.password()).isCompromised()) {
            apiResponse.addError(ApiResponseCode.COMPROMISED_PASSWORD, "password", "La contraseña proporcionada está comprometida. Por favor use otra contraseña");
        }

        if (usuarioDto.roles().stream().anyMatch(rolDto -> rolDto.nombre().equalsIgnoreCase("Fabricante"))) {
            if (usuarioDto.licencia_fabricante() != null) {
                return this.validateRegistrationFabricante(usuarioDto, apiResponse);
            }
            apiResponse.addError(ApiResponseCode.MISSING_INFORMATION, "licencia_fabricante", "Los fabricantes requieren licencia autorizada por Dirección Nacional de Farmacia y Drogas del MINSA");
        } else {
            if (usuarioDto.cedula() != null || usuarioDto.pasaporte() != null) {
                return this.validateRegistrationPersona(usuarioDto, apiResponse);
            }

            apiResponse.addError(ApiResponseCode.MISSING_INFORMATION, "Las personas requieren una identificación personal como cédula panameña o pasaporte");
        }

        return null;
    }

    Persona validateRegistrationPersona(UsuarioDto usuarioDto, IApiResponse<String, Object> apiResponse) {
        AtomicReference<Persona> personaResponse = new AtomicReference<>(null);
        String identifier = usuarioDto.cedula() != null ? usuarioDto.cedula() : usuarioDto.pasaporte();

        assert identifier != null;

        this.personaService.getPersona(identifier).ifPresentOrElse(persona -> {
            if (Boolean.FALSE.equals(persona.getDisabled())) {
                Usuario user = persona.getUsuario();
                if (user != null && user.getId() != null) {
                    log.debug("Usuario de persona: {}", user.getId());
                    apiResponse.addError(ApiResponseCode.ALREADY_EXISTS, "La persona ya tiene un usuario registrado");
                } else {
                    personaResponse.set(persona);
                }
            } else {
                log.debug("Persona attempting register but is disabled. ID: {}", persona.getId());
                apiResponse.addError(HttpStatus.FORBIDDEN.toString(), "No puede registrarse");
            }

        }, () -> {
            apiResponse.addError(ApiResponseCode.NOT_FOUND, "La persona con la identificación personal proporcionada no fue encontrado");
        });
        return personaResponse.get();
    }

    Fabricante validateRegistrationFabricante(UsuarioDto usuarioDto, IApiResponse<String, Object> apiResponse) {
        AtomicReference<Fabricante> fabricanteResponse = new AtomicReference<>(null);
        this.fabricanteService.getFabricante(usuarioDto.licencia_fabricante()).ifPresentOrElse(fabricante -> {
            if (Boolean.FALSE.equals(fabricante.getDisabled())) {
                Usuario user = fabricante.getUsuario();
                if (user != null && user.getId() != null) {
                    log.debug("Usuario de fabricante: {}", user.getId());
                    apiResponse.addError(ApiResponseCode.ALREADY_EXISTS, "El fabricante ya tiene un usuario registrado");
                } else {
                    fabricanteResponse.set(fabricante);
                }
            } else {
                log.debug("Fabricante attempting register but is disabled. ID: {}", fabricante.getId());
                apiResponse.addError(HttpStatus.FORBIDDEN.toString(), "No puede registrarse");
            }

        }, () -> {
            apiResponse.addError(ApiResponseCode.NOT_FOUND, "El fabricante con la licencia proporcionada no fue encontrado");
        });
        return fabricanteResponse.get();
    }

    void validateChangePasswordPersona(Persona persona, String newPassword, LocalDate birthdate, IApiResponse<?, Object> apiResponse) {
        if (!persona.getFechaNacimiento().toLocalDate().equals(birthdate)) {
            apiResponse.addError(ApiResponseCode.VALIDATION_FAILED, "La fecha de cumpleaños no coincide");
        }

        if (this.passwordEncoder.matches(newPassword, persona.getUsuario().getClave())) {
            apiResponse.addError(ApiResponseCode.VALIDATION_FAILED, "La nueva contraseña no puede ser igual a la contraseña actual");
        }

        if (persona.getUsuario().getUsername() != null && persona.getUsuario().getUsername().equalsIgnoreCase(newPassword)) {
            apiResponse.addError(ApiResponseCode.VALIDATION_FAILED, "La nueva contraseña no puede ser igual a su username");
        }

        if (this.compromisedPasswordChecker.check(newPassword).isCompromised()) {
            apiResponse.addError(ApiResponseCode.VALIDATION_FAILED, "La nueva contraseña está comprometida, utilice contraseñas seguras");
        }

    }

    boolean isCedulaRegistered(String cedula) {
        return cedula != null && usuarioRepository.findByCedula(cedula).isPresent();
    }

    boolean isUsernameRegistered(String username) {
        return username != null && usuarioRepository.findByUsername(username).isPresent();
    }

    boolean isCorreoRegistered(String correo) {
        return correo != null && (usuarioRepository.findByCorreoPersona(correo).isPresent() || usuarioRepository.findByCorreoFabricante(correo).isPresent());
    }

    boolean isLicenciaFabricanteRegistered(String licencia) {
        return licencia != null && usuarioRepository.findByLicencia(licencia).isPresent();
    }

    boolean canRegisterRole(RolDto rolDto, List<RolesEnum> authenticatedRoles) {
        int maxRolPriority = authenticatedRoles.stream()
                .mapToInt(RolesEnum::getPriority)
                .max()
                .orElse(0);

        return RolesEnum.valueOf(rolDto.nombre().toUpperCase()).getPriority() <= maxRolPriority;
    }

    boolean hasUserManagementPermissions(List<String> authenticatedAuthorities) {
        return authenticatedAuthorities.contains("ADMINISTRATIVO_WRITE")
                || authenticatedAuthorities.contains("AUTORIDAD_WRITE")
                || authenticatedAuthorities.contains("USER_MANAGER_WRITE");
    }
}
