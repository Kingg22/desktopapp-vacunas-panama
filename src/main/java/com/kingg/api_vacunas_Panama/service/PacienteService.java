package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.util.mapper.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final MapStructMapper mapStructMapper;
    private final PacienteRepository pacienteRepository;

    public Optional<PacienteDto> getPaciente(String cedula) {
        return pacienteRepository.findById(cedula).map(mapStructMapper::pacienteToPacienteDto);
    }

}
