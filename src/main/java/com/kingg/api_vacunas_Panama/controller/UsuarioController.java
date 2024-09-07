package com.kingg.api_vacunas_panama.controller;

import com.kingg.api_vacunas_panama.dto.LoginDto;
import com.kingg.api_vacunas_panama.dto.UsuarioDto;
import com.kingg.api_vacunas_panama.entity.Usuario;
import com.kingg.api_vacunas_panama.repositories.UsuarioRepository;
import com.kingg.api_vacunas_panama.services.TokenService;
import com.kingg.api_vacunas_panama.services.UsuarioManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api_vacunas/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final UsuarioManagementService usuarioManagementService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, TokenService tokenService,
                             UsuarioManagementService usuarioManagementService,
                             AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.usuarioManagementService = usuarioManagementService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UsuarioDto usuarioDto, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errorsList = result.getAllErrors();
            Map<String, String> errorsMap = new HashMap<>();

            for (ObjectError error : errorsList) {
                FieldError fieldError = (FieldError) error;
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorsMap);
        }

        try {
            Optional<Usuario> testUsuario;
            if (usuarioDto.cedula() != null) {
                testUsuario = usuarioRepository.findByCedula(usuarioDto.cedula());
                if (testUsuario.isPresent()) {
                    return ResponseEntity.badRequest().body("Cédula is already registered");
                }
            }
            if (usuarioDto.username() != null) {
                testUsuario = usuarioRepository.findByUsuario(usuarioDto.username());
                if (testUsuario.isPresent()) {
                    return ResponseEntity.badRequest().body("Username is already used");
                }
            }
            if (usuarioDto.correoElectronicoUsuario() != null) {
                testUsuario = usuarioRepository.findByCorreoElectronicoUsuario(usuarioDto.correoElectronicoUsuario());
                if (testUsuario.isPresent()) {
                    return ResponseEntity.badRequest().body("Email is already registered");
                }
            }

            Usuario saveUser = usuarioManagementService.createUser(usuarioDto);

            Map<String, Object> response = new HashMap<>();
            response.put("Token", tokenService.generateToken(saveUser));
            response.put("User", saveUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error while creating the user");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errorsList = result.getAllErrors();
            Map<String, String> errorsMap = new HashMap<>();

            for (ObjectError error : errorsList) {
                FieldError fieldError = (FieldError) error;
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorsMap);
        }

        try {
            Authentication user = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.username(),
                    loginDto.password()
            ));
            Map<String, Object> response = new HashMap<>();
            response.put("Token", tokenService.generateToken(user));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error while authenticating the user");
        }
    }

    @GetMapping
    public ResponseEntity<Object> profile(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        Optional<Usuario> usuario = usuarioRepository.findByCedulaOrCorreoElectronicoUsuarioOrUsuario(
                                    authentication.getName(), authentication.getName(), authentication.getName());
        if (usuario.isPresent()) {
            response.put("Username", authentication.getName());
            response.put("Authorities", authentication.getAuthorities());
            response.put("User", usuario.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("Error, user not found. Retry with new token");
    }

}
