package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.persistence.repository.ViewPacientesVacunasEnfermedadesRepository;
import com.kingg.api_vacunas_panama.util.mapper.PacienteMapper;
import com.kingg.api_vacunas_panama.web.dto.ViewPacientesVacunasEnfermedadesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteMapper pacienteMapper;
    private final PacienteRepository pacienteRepository;
    private final ViewPacientesVacunasEnfermedadesRepository viewPacientesVacunasEnfermedadesRepository;

    public Optional<ViewPacientesVacunasEnfermedadesDto> getViewEnfermedad(String cedula) {
        return viewPacientesVacunasEnfermedadesRepository.findById(cedula).map(pacienteMapper::viewPacienteVacunaEnfermedadToDto);
    }

}
