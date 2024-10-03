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
            "WHERE (:cedula IS NULL OR p.cedula = :cedula) OR " +
            "(:pasaporte IS NULL OR p.pasaporte = :pasaporte) OR " +
            "(:correo IS NULL OR p.correo = :correo) OR " +
            "(:username IS NULL OR p.usuario.username = :username)")
    Optional<Persona> findByCedulaOrPasaporteOrCorreoOrUsername(@Param("cedula") String cedula,
                                                                @Param("pasaporte") String pasaporte,
                                                                @Param("correo") String correo,
                                                                @Param("username") String username);

    Optional<Persona> findByUsuario_Id(UUID id);

}