package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.util.mapper.PacienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteMapper pacienteMapper;
    private final PacienteRepository pacienteRepository;

    public Map<String, Object> getViewVacunaEnfermedad(String cedula) {
        return pacienteRepository.findById(cedula)
                .map(paciente -> Map.of(
                        "paciente", pacienteMapper.pacienteToDto(paciente),
                        "view_vacuna_enfermedad", pacienteRepository.findAllFromViewVacunaEnfermedad(cedula)
                ))
                .orElseGet(() -> Map.of(
                        "paciente", "",
                        "view_vacuna_enfermedad", List.of()
                ));
    }

}
