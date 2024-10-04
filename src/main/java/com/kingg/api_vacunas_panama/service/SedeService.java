package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import com.kingg.api_vacunas_panama.persistence.repository.SedeRepository;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.util.mapper.SedeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service for {@link Sede}.
 */
@Service
@RequiredArgsConstructor
public class SedeService {
    private final SedeMapper mapper;
    private final SedeRepository sedeRepository;

    public UUID getIdSede(String nombreSede) {
        return sedeRepository.findByNombre(nombreSede).map(Sede::getId).orElse(null);
    }

    public void getIdNombreSedes(IApiResponse<?, ?, Object> response) {
        response.addData("sedes", sedeRepository.findAllIdAndNombre());
    }
}
