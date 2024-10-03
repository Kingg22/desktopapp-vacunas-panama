package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByUsername(String usuario);

    @Query("SELECT p.usuario " +
            "FROM Persona p " +
            "WHERE (:cedula IS NULL OR p.cedula = :cedula) OR " +
            "(:pasaporte IS NULL OR p.pasaporte = :pasaporte) OR " +
            "(:correo IS NULL OR p.correo = :correo)")
    Optional<Usuario> findByCedulaOrPasaporteOrCorreo(@Param("cedula") String cedula, @Param("pasaporte") String pasaporte, @Param("correo") String correo);

    @Query("SELECT e.usuario " +
            "FROM Fabricante f " +
            "LEFT JOIN Entidad e ON f.id = e.id " +
            "WHERE (:licencia IS NULL OR f.licencia = :licencia) OR " +
            "(:correo IS NULL OR f.correo = :correo)")
    Optional<Usuario> findByLicenciaOrCorreo(@Param("licencia") String licencia, @Param("correo") String correo);

    @Query("SELECT p.usuario FROM Persona p WHERE p.cedula = :cedula")
    Optional<Usuario> findByCedula(@Param("cedula") String cedula);

    @Query("SELECT p.usuario FROM Persona p WHERE p.correo = :correo")
    Optional<Usuario> findByCorreoPersona(@Param("correo") String correo);

    @Query("SELECT e.usuario FROM Entidad e WHERE e.correo = :correo")
    Optional<Usuario> findByCorreoEntidad(@Param("correo") String correo);

    @Query("SELECT f.usuario FROM Fabricante f WHERE f.licencia = :licencia")
    Optional<Usuario> findByLicencia(@Param("licencia") String licencia);

}
