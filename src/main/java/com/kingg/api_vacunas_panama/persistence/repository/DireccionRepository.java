package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DireccionRepository extends JpaRepository<Direccion, UUID> {

    Optional<Direccion> findByDireccion(String direccion);

    Optional<Direccion> findByDireccionAndDistritoId(String direccion, Short idDistrito);

}