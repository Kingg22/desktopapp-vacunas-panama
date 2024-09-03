package com.kingg.api_vacunas_Panama.controller;

import com.kingg.api_vacunas_Panama.dto.PacienteDTO;
import com.kingg.api_vacunas_Panama.entity.Paciente;
import com.kingg.api_vacunas_Panama.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api_vacunas/v1/paciente", produces = "application/json")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<PacienteDTO> getPaciente(@PathVariable String cedula) {
        return ResponseEntity.ok(pacienteService.getPacienteByCedula(cedula).orElse(null));
    }
}
