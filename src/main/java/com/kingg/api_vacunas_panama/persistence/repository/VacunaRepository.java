package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VacunaRepository extends JpaRepository<Vacuna, UUID> {
    Optional<Vacuna> findByNombreVacuna(String nombre);

}