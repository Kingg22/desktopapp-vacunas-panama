package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import com.kingg.api_vacunas_panama.web.dto.UUIDNombreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<Sede, UUID> {

    Optional<Sede> findByNombre(String nombre);

    @Query("SELECT new com.kingg.api_vacunas_panama.web.dto.UUIDNombreDto(s.id, s.nombre) FROM Sede s WHERE s.estado LIKE 'ACTIVO'")
    List<UUIDNombreDto> findAllIdAndNombre();

}