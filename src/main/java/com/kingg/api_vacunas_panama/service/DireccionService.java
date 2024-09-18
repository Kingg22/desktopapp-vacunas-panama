package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Distrito;
import com.kingg.api_vacunas_panama.persistence.repository.DistritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DireccionService {

    private final DistritoRepository distritoRepository;

    public Distrito getDistrito(Short id) {
        return distritoRepository.findById(id).orElse(null);
    }

    public Distrito getDistrito(String nombreDistrito) {
        return distritoRepository.findByNombreDistrito(nombreDistrito).orElse(null);
    }

}
