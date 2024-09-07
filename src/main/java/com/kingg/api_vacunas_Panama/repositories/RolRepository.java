package com.kingg.api_vacunas_panama.repositories;

import com.kingg.api_vacunas_panama.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombreRolOrId(String nombreRol, Integer id);

}