package com.kingg.api_vacunas_panama.repositories;

import com.kingg.api_vacunas_panama.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
