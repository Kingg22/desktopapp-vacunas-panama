package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import com.kingg.api_vacunas_panama.persistence.repository.SedeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SedeService {
    private final SedeRepository sedeRepository;

    public UUID getIdSede(String nombreSede) {
        return sedeRepository.findByNombreSede(nombreSede).map(Sede::getId).orElse(null);
    }

}
