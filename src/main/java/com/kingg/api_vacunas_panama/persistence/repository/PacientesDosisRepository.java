package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.persistence.entity.PacientesDosis;
import com.kingg.api_vacunas_panama.persistence.entity.PacientesDosisId;
import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacientesDosisRepository extends JpaRepository<PacientesDosis, PacientesDosisId> {

    Optional<PacientesDosis> findTopByPacienteAndDosis_VacunaOrderByCreatedAtDesc(Paciente paciente, Vacuna vacuna);

    List<PacientesDosis> findAllByPaciente_Id(UUID idPaciente);

    List<PacientesDosis> findAllByPaciente_IdAndDosis_Vacuna_Id(UUID idPaciente, UUID idVacuna);

}