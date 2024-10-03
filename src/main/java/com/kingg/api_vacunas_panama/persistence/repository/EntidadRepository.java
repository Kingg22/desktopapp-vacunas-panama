package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EntidadRepository extends JpaRepository<Entidad, UUID> {

    Optional<Entidad> findByUsuario_Id(UUID idUsuario);

}