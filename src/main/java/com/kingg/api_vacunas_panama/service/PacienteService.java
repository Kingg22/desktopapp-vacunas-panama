package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.web.dto.ViewPacienteVacunaEnfermedadDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service for {@link Paciente}.
 * Extends {@link PersonaService} to inherit methods for directly modifying all details related to a {@link Paciente}.
 * This service allows for comprehensive management of patient information and integrates with
 * the underlying personal data structure.
 */
@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Cacheable(cacheNames = "cache", key = "'view_vacuna_enfermedad'.concat(#idPaciente)")
    public List<ViewPacienteVacunaEnfermedadDto> getViewVacunaEnfermedad(UUID idPaciente) {
        List<ViewPacienteVacunaEnfermedadDto> view = this.pacienteRepository.findAllFromViewVacunaEnfermedad(idPaciente);
        if (view.isEmpty()) {
            return List.of();
        } else {
            return view;
        }
    }

    public Optional<Paciente> getPacienteByUserID(@NotNull UUID idUser) {
        return this.pacienteRepository.findByUsuario_Id(idUser);
    }

}
