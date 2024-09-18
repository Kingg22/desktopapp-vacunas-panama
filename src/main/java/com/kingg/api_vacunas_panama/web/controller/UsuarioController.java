package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.TokenService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.ResponseUtil;
import com.kingg.api_vacunas_panama.util.RolEnum;
import com.kingg.api_vacunas_panama.web.dto.LoginDto;
import com.kingg.api_vacunas_panama.web.dto.RestoreDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.servlet.http.HttpServletRequest;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final TokenService tokenService;
    private final UsuarioManagementService usuarioManagementService;
    private final AuthenticationManager authenticationManager;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UsuarioDto usuarioDto, Authentication authentication, HttpServletRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        MultiValueMap<String, Object> errors = new LinkedMultiValueMap<>();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            if (!usuarioDto.roles().stream().allMatch(rolDto -> rolDto.nombre().equalsIgnoreCase("Paciente"))) {
                errors.add("message", "Only patients can register without authentication");
            }
        } else {
            List<String> authenticatedAuthorities = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            List<RolEnum> authenticatedRoles = authenticatedAuthorities.stream()
                    .map(RolEnum::valueOf)
                    .toList();

            if (!usuarioDto.roles().stream()
                    .allMatch(rolDto -> usuarioManagementService.canRegisterRole(rolDto, authenticatedRoles))) {
                errors.add("message", "You cannot assign roles higher than your own role");
            }

            if (!usuarioManagementService.hasUserManagementPermissions(authenticatedAuthorities)) {
                errors.add("message", "You don't have permission to register other roles");
            }
        }
        if (!errors.isEmpty()) {
            status.put("code", HttpStatus.FORBIDDEN.value());
            status.put("message", "Insufficient authorities");
            return ResponseEntity.badRequest().body(ResponseUtil.createResponse(status, Map.of(), errors, null, request));
        }

        if (usuarioManagementService.isCedulaRegistered(usuarioDto.cedula())) {
            errors.add("message", "Cédula is already registered");
        }
        if (usuarioManagementService.isUsernameRegistered(usuarioDto.username())) {
            errors.add("message", "Username is already used");
        }
        if (usuarioManagementService.isCorreoRegistered(usuarioDto.email())) {
            errors.add("message", "Email is already registered");
        }
        if (compromisedPasswordChecker.check(usuarioDto.password()).isCompromised()) {
            errors.add("code", "COMPROMISED_PASSWORD");
            errors.add("message", "The password you provided is compromised. Please use another one");
        }
        if (!errors.isEmpty()) {
            status.put("code", HttpStatus.BAD_REQUEST.value());
            status.put("message", "Validation failed");
            return ResponseEntity.badRequest().body(ResponseUtil.createResponse(status, Map.of(), errors, null, request));
        }

        UsuarioDto saveUser = usuarioManagementService.createUser(usuarioDto);
        status.put("code", HttpStatus.CREATED.value());
        status.put("message", "Successful user creation");
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("user", saveUser);
        data.put("token", tokenService.generateToken(saveUser));
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseUtil.createResponse(status, data, null, null, request));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto, HttpServletRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        MultiValueMap<String, Object> errors = new LinkedMultiValueMap<>();
        if (compromisedPasswordChecker.check(loginDto.password()).isCompromised()) {
            status.put("code", HttpStatus.TEMPORARY_REDIRECT.value());
            status.put("message", "Please reset your password in the given uri");
            status.put("uri", "/vacunacion/v1/account/restore");
            errors.add("code", "COMPROMISED_PASSWORD");
            errors.add("message", "The password you provided is compromised");
            return ResponseEntity.badRequest().body(ResponseUtil.createResponse(status, Map.of(), errors, null, request));
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.username(),
                loginDto.password()
        ));
        UsuarioDto user = usuarioManagementService.getUsuario(authentication.getName());
        status.put("code", HttpStatus.OK.value());
        status.put("message", "Login successful");
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("user", user);
        data.put("token", tokenService.generateToken(authentication));
        return ResponseEntity.ok(ResponseUtil.createResponse(status, data, null, null, request));
    }

    @PatchMapping("/restore")
    public ResponseEntity<Object> restore(@RequestBody @Valid RestoreDto restoreDto, HttpServletRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        MultiValueMap<String, Object> errors = new LinkedMultiValueMap<>();
        if (!compromisedPasswordChecker.check(restoreDto.new_password()).isCompromised()) {
            try {
                usuarioManagementService.changePassword(restoreDto.username(), restoreDto.new_password(), restoreDto.fecha_nacimiento_usuario());
                status.put("code", HttpStatus.OK.value());
                status.put("message", "Password restored successfully");
                return ResponseEntity.ok(ResponseUtil.createResponse(status, Map.of(), null, null, request));
            } catch (IllegalArgumentException argumentException) {
                status.put("code", HttpStatus.BAD_REQUEST.value());
                status.put("message", "Failed to change password");
                errors.add("message", argumentException.getMessage());
                return ResponseEntity.badRequest().body(ResponseUtil.createResponse(status, Map.of(), errors, null, request));
            }
        } else {
            status.put("code", HttpStatus.BAD_REQUEST.value());
            status.put("message", "Insecure password");
            errors.add("code", "COMPROMISED_PASSWORD");
            errors.add("message", "new password is compromised, please use another");
            return ResponseEntity.badRequest().body(ResponseUtil.createResponse(status, Map.of(), errors, null, request));
        }
    }

    @GetMapping
    public ResponseEntity<Object> profile(Authentication authentication, HttpServletRequest request) {
        UsuarioDto user = usuarioManagementService.getUsuario(authentication.getName());
        return ResponseEntity.ok(ResponseUtil.createResponse(Map.of("code", HttpStatus.OK.value()), Map.of("user", user), null, null, request));
    }

}
