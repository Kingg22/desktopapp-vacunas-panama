package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DireccionRepository extends JpaRepository<Direccion, UUID> {

    Optional<Direccion> findDireccionByDireccionAndDistrito_Id(String direccion, int idDistrito);

    Optional<Direccion> findDireccionByDireccionContainingIgnoreCase(String direccion);

    Optional<Direccion> findDireccionByDireccionAndDistrito_Nombre(String direccion, String distrito);

}