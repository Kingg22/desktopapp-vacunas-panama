package com.kingg.api_vacunas_panama.repositories;

import com.kingg.api_vacunas_panama.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

    Optional<Permiso> findByNombrePermisoOrId(String nombre, Integer id);
}