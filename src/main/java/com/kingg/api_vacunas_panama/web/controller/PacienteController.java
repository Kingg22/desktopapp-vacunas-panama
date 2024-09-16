package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Object> getPaciente() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(pacienteService.getPaciente(authentication.getName()).orElse(null));
    }
}
