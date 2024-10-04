package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.persistence.entity.*;
import com.kingg.api_vacunas_panama.service.PersonaService;
import com.kingg.api_vacunas_panama.service.TokenService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.ApiContentResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.ApiResponseUtil;
import com.kingg.api_vacunas_panama.web.dto.LoginDto;
import com.kingg.api_vacunas_panama.web.dto.RestoreDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Controller for {@link Usuario} registration and management, {@link Rol} and {@link Permiso}.
 * <p>
 * This controller handles operations related to registering users and managing their roles and associated entities
 * (e.g., {@link Paciente}, {@link Doctor}, {@link Fabricante}). It ensures that users are linked to an existing {@link Persona} or {@link Entidad}
 * and properly assigned roles.
 *
 * <p><b>Response Format:</b> The response for registration and related endpoints typically includes:</p>
 * <ul>
 *   <li>User details (e.g., username, roles, etc.).</li>
 *   <li>Associated {@link Persona} or {@link Entidad} information (e.g., {@link Paciente}, {@link Doctor}, {@link Fabricante})
 *   if applicable.</li>
 *   <li>A JWT token, which is only generated if the associated persona or entity has an active (validated) status.</li>
 * </ul>
 * <p>
 * For cases where both the {@link Persona}/{@link Entidad} and the {@link Usuario} need to created in a single request,
 * a different endpoint should be used.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final TokenService tokenService;
    private final UsuarioManagementService usuarioManagementService;
    private final PersonaService personaService;
    private final AuthenticationManager authenticationManager;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    /**
     * Handles user registration.
     * <p>
     * First, it checks if the current {@link Authentication} is for an authenticated user with sufficient permissions
     * to create users with lower {@link Rol}. If not authenticated, it allows registering a {@link Paciente}.
     * It also validates tha data to be registered (e.g., username, email) is not currently in use.
     * <p>
     * If all validations pass, the {@link Usuario} is created.
     * <p><b>Note:</b> The user must be assigned roles, and empty roles are not allowed.
     * If the associated entities is not created, the request will be rejected.</p>
     *
     * @param usuarioDto     the data transfer object containing the user registration details
     * @param authentication the authentication object representing the current user (if any)
     * @param request        the HTTP request object containing additional request data
     * @return a {@link ResponseEntity} containing the registration result, including user details, associated {@link Persona} or {@link Entidad}
     * information, and a token if the {@link Persona} or {@link Entidad} is validated and active.
     */
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UsuarioDto usuarioDto, Authentication authentication, ServletWebRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        ApiContentResponse apiContentResponse = new ApiContentResponse();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            if (!usuarioDto.roles().stream().allMatch(rolDto -> rolDto.nombre().equalsIgnoreCase("Paciente"))) {
                apiContentResponse.addError("code", ApiResponseCode.MISSING_ROLE_OR_PERMISSION.toString());
                apiContentResponse.addError("message", "Solo pacientes pueden registrarse sin autenticación");
            }
        } else {
            usuarioManagementService.validateAuthoritiesRegister(usuarioDto, apiContentResponse, authentication);
        }
        if (!apiContentResponse.hasErrors()) {
            UsuarioDto saveUser = usuarioManagementService.createUser(usuarioDto, apiContentResponse);
            if (!apiContentResponse.hasErrors()) {
                status.put("code", HttpStatus.CREATED.value());
                status.put("message", "Successful user creation");
                apiContentResponse.addData("user", saveUser);
                apiContentResponse.addData("token", tokenService.generateToken(saveUser));
            } else {
                status.put("code", HttpStatus.BAD_REQUEST.value());
                status.put("message", ApiResponseCode.VALIDATION_FAILED.toString());
            }
        } else {
            status.put("code", HttpStatus.FORBIDDEN.value());
            status.put("message", "Insufficient authorities");
        }
        return ApiResponseUtil.sendResponse(status, apiContentResponse, request);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto, ServletWebRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        ApiContentResponse apiContentResponse = new ApiContentResponse();

        if (compromisedPasswordChecker.check(loginDto.password()).isCompromised()) {
            status.put("code", HttpStatus.TEMPORARY_REDIRECT.value());
            status.put("message", "Please reset your password in the given uri");
            status.put("uri", "/vacunacion/v1/account/restore");
            apiContentResponse.addError("code", ApiResponseCode.COMPROMISED_PASSWORD.toString());
            apiContentResponse.addError("message", "The password you provided is compromised");
        } else {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.username(),
                    loginDto.password()
            ));
            if (authentication != null && authentication.isAuthenticated()) {
                UsuarioDto user = usuarioManagementService.getUsuarioDto(UUID.fromString(authentication.getName()));
                status.put("code", HttpStatus.OK.value());
                status.put("message", "Login successful");
                apiContentResponse.addData("user", user);
                apiContentResponse.addData("token", tokenService.generateToken(authentication));
            }
        }
        return ApiResponseUtil.sendResponse(status, apiContentResponse, request);
    }

    @PatchMapping("/restore")
    public ResponseEntity<Object> restore(@RequestBody @Valid RestoreDto restoreDto, ServletWebRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        ApiContentResponse apiContentResponse = new ApiContentResponse();
        if (!compromisedPasswordChecker.check(restoreDto.new_password()).isCompromised()) {
            try {
                Optional<Persona> opPersona = personaService.getPersona(restoreDto.username());
                if (opPersona.isPresent()) {
                    usuarioManagementService.changePasswordPersonas(opPersona.get(), restoreDto.new_password(), restoreDto.fecha_nacimiento());
                    status.put("code", HttpStatus.OK.value());
                    status.put("message", "Password restored successfully");
                } else {
                    status.put("code", HttpStatus.NOT_FOUND.value());
                    status.put("message", "Not found person with identifier");
                    apiContentResponse.addError("code", ApiResponseCode.NOT_FOUND.toString());
                    apiContentResponse.addError("message", "La persona con la identificación dada no fue encontrada");
                }
            } catch (IllegalArgumentException argumentException) {
                status.put("code", HttpStatus.BAD_REQUEST.value());
                status.put("message", "Failed to change password");
                apiContentResponse.addError("code", ApiResponseCode.VALIDATION_FAILED.toString());
                apiContentResponse.addError("message", argumentException.getMessage());
            }
        } else {
            status.put("code", HttpStatus.BAD_REQUEST.value());
            status.put("message", "Insecure password");
            apiContentResponse.addError("code", ApiResponseCode.COMPROMISED_PASSWORD.toString());
            apiContentResponse.addError("message", "La nueva contraseña está comprometida, por favor usar otra contraseña segura");
        }
        return ApiResponseUtil.sendResponse(status, apiContentResponse, request);
    }

    @GetMapping
    public ResponseEntity<Object> profile(Authentication authentication, ServletWebRequest request) {
        ApiContentResponse apiContentResponse = new ApiContentResponse();
        apiContentResponse.addData("user", usuarioManagementService.getUsuarioDto(UUID.fromString(authentication.getName())));
        return ApiResponseUtil.sendResponse(Map.of("code", HttpStatus.OK.value()), apiContentResponse, request);
    }

}
