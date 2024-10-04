package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Dosis;
import com.kingg.api_vacunas_panama.persistence.entity.PacientesDosis;
import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import com.kingg.api_vacunas_panama.persistence.repository.DosisRepository;
import com.kingg.api_vacunas_panama.persistence.repository.PacienteRepository;
import com.kingg.api_vacunas_panama.persistence.repository.VacunaRepository;
import com.kingg.api_vacunas_panama.util.ApiContentResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.util.NumDosisEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/**
 * Service for {@link Vacuna}, {@link Dosis} and {@link PacientesDosis}.
 */
@Service
@RequiredArgsConstructor
public class VacunaService {
    private final DosisRepository dosisRepository;
    private final PacienteRepository pacienteRepository;
    private final VacunaRepository vacunaRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean insertDosis(String cedula, LocalDateTime fechaAplicacion, NumDosisEnum numeroDosis, UUID idVacuna,
                               UUID idSede, UUID idDoctor, String lote) {

        return false;
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
        return vacunaRepository.findByNombre(nombreVacuna).map(Vacuna::getId).orElse(null);
    }

    public UUID validateAndGetId(UUID id, String nombre, ApiContentResponse apiContentResponse, String tipo, Function<String, UUID> getIdFunction) {
        if (id == null && nombre == null) {
            apiContentResponse.addError(tipo, "El ID o nombre del ".concat(tipo).concat(" es requerido"));
        } else if (id == null) {
            apiContentResponse.addWarning("code", ApiResponseCode.MISSING_INFORMATION.toString());
            apiContentResponse.addWarning(tipo, "Procure usar id y no nombres de ".concat(tipo));
            id = getIdFunction.apply(nombre);
            if (id == null) {
                apiContentResponse.addError(tipo, "Failed convert nombre to ID");
            }
        } else {
            apiContentResponse.addWarning("code", ApiResponseCode.NAME_IGNORED_FOR_ID.toString());
            apiContentResponse.addWarning(tipo, "El nombre del ".concat(tipo).concat("proporcionado fue ignorado para la operación"));
        }
        return id;
    }

    public void getVacunas(IApiResponse<?, ?, Object> response) {
        response.addData("vacunas", vacunaRepository.findAllIdAndNombreAndFabricante());
    }
}
