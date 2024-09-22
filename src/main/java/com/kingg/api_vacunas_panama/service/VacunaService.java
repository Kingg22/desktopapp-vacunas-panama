package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Dosis;
import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import com.kingg.api_vacunas_panama.persistence.repository.DosisRepository;
import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.persistence.repository.VacunaRepository;
import com.kingg.api_vacunas_panama.util.NumDosisEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VacunaService {
    private final DosisRepository dosisRepository;
    private final PacienteRepository pacienteRepository;
    private final VacunaRepository vacunaRepository;

    public boolean insertDosis(String cedula, LocalDateTime fechaAplicacion, NumDosisEnum numeroDosis, UUID id_vacuna,
                               UUID sede, String lote) {
        return dosisRepository.insert(cedula, fechaAplicacion, numeroDosis.getValue(), id_vacuna, null, sede, null, lote) > 0;
    }

    public boolean validNumDosis(String cedula, UUID vacuna, NumDosisEnum numDosisNueva) {
        List<Dosis> dosisPaciente = dosisRepository.findByCedulaAndIdVacuna(cedula, vacuna);
        if (!dosisPaciente.isEmpty()) {
            return dosisPaciente.getFirst().getNumeroDosis().isValidNew(numDosisNueva);
        } else {
            return numDosisNueva.getValue().matches("^[P1]$");
        }
    }

    public UUID getIdVacuna(String nombreVacuna) {
        return vacunaRepository.findByNombreVacuna(nombreVacuna).map(Vacuna::getId).orElse(null);
    }

}
