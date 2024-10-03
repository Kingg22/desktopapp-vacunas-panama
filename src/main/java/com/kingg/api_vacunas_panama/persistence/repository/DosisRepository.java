package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Dosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DosisRepository extends JpaRepository<Dosis, UUID> {

    @Query("SELECT d FROM Dosis d JOIN d.pacientes p WHERE p.cedula = :cedula")
    List<Dosis> findByCedula(@Param("cedula") String cedula);

    @Query("SELECT d FROM Dosis d JOIN d.pacientes p WHERE p.cedula = :cedula AND d.idVacuna.id = :id_vacuna ORDER BY d.fechaAplicacion DESC")
    List<Dosis> findByCedulaAndIdVacuna(@Param("cedula") String cedula, @Param("id_vacuna") UUID vacuna);

}