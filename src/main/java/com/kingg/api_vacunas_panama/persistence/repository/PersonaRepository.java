package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PersonaRepository extends JpaRepository<Persona, UUID> {

    @Query("SELECT p " +
            "FROM Persona p " +
            "WHERE (:cedula IS NOT NULL AND p.cedula = :cedula) OR " +
            "(:pasaporte IS NOT NULL AND p.pasaporte = :pasaporte) OR " +
            "(:correo IS NOT NULL AND p.correo = :correo) OR " +
            "(:username IS NOT NULL AND p.usuario.username = :username)")
    Optional<Persona> findByCedulaOrPasaporteOrCorreoOrUsername(@Param("cedula") String cedula,
                                                                @Param("pasaporte") String pasaporte,
                                                                @Param("correo") String correo,
                                                                @Param("username") String username);

    Optional<Persona> findByUsuario_Id(UUID id);

}