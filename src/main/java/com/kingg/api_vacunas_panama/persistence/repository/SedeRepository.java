package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<Sede, UUID> {
    Optional<Sede> findByNombreSede(String nombre);

}