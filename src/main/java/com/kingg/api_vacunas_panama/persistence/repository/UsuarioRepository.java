package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String usuario);

    Optional<Usuario> findByCorreoUsuario(String email);

    Optional<Usuario> findByCedula(String cedula);

    Optional<Usuario> findByCedulaOrCorreoUsuarioOrUsername(String cedula, String correo, String usuario);

}
