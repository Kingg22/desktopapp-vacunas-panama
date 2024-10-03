package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<Sede, UUID> {

    Optional<Sede> findByNombre(String nombre);

    @Query("SELECT s.nombre FROM Sede s")
    List<String> findAllNombre();

}