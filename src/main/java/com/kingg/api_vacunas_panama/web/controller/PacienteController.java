package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.PacienteService;
import com.kingg.api_vacunas_panama.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Object> getPaciente(Authentication authentication, HttpServletRequest request) {
        return ResponseUtil.sendResponse(
                Map.of("code", HttpStatus.OK.value()),
                pacienteService.getViewVacunaEnfermedad(UUID.fromString(authentication.getName())),
                request);
    }

}
