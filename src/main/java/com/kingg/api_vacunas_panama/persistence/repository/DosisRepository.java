package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Dosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DosisRepository extends JpaRepository<Dosis, UUID> {
}