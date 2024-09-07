package com.kingg.api_vacunas_panama.controller;

import com.kingg.api_vacunas_panama.dto.PacienteDto;
import com.kingg.api_vacunas_panama.services.PacienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api_vacunas/v1/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<PacienteDto> getPaciente
            (@Valid
             @Pattern(regexp = "^((RN(\\d{1,2}?)?-)?(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?))-(\\d{1,4})-(\\d{1,6})$|^NI-(\\d*)$|^[A-Z0-9]{5,20}$", message = "Cédula no match patterns")
             @RequestBody
             String cedula) {
        return ResponseEntity.ok(pacienteService.getPacienteByCedula(cedula).orElse(null));
    }
}
