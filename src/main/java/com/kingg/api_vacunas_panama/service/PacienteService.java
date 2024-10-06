package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.web.dto.ViewPacienteVacunaEnfermedadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void getViewVacunaEnfermedad(UUID id, IApiResponse<?, Object> apiResponse) {
        List<ViewPacienteVacunaEnfermedadDto> view = this.pacienteRepository.findAllFromViewVacunaEnfermedad(id);
        if (view.isEmpty()) {
            apiResponse.addData("view_vacuna_enfermedad", List.of());
            apiResponse.addError(ApiResponseCode.NOT_FOUND, "El paciente no tiene dosis registradas");
        } else {
            apiResponse.addData("view_vacuna_enfermedad", view);
        }

    }

}
