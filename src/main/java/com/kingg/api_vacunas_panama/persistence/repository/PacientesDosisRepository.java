package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacientesDosisRepository extends JpaRepository<PacientesDosis, PacientesDosisId> {

    Optional<PacientesDosis> findTopByPacienteAndDosis_IdVacunaOrderByCreatedAtDesc (Paciente paciente, Vacuna vacuna);

}