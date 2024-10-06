package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Dosis;
import com.kingg.api_vacunas_panama.persistence.entity.PacientesDosis;
import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import com.kingg.api_vacunas_panama.persistence.repository.DosisRepository;
import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.persistence.repository.VacunaRepository;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for {@link Vacuna}, {@link Dosis} and {@link PacientesDosis}.
 */
@Service
@RequiredArgsConstructor
public class VacunaService {
    private final DosisRepository dosisRepository;
    private final PacienteRepository pacienteRepository;
    private final VacunaRepository vacunaRepository;

    public void getVacunas(IApiResponse<?, Object> response) {
        response.addData("vacunas", vacunaRepository.findAllIdAndNombreAndFabricante());
    }
}
