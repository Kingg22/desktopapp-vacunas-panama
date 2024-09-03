package com.kingg.api_vacunas_Panama.repositories;

import com.kingg.api_vacunas_Panama.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
