package com.kingg.api_vacunas_panama.repositories;

import com.kingg.api_vacunas_panama.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuario(String usuario);

    Optional<Usuario> findByCorreoElectronicoUsuario(String email);

    Optional<Usuario> findByCedula(String cedula);

    Optional<Usuario> findByCedulaOrCorreoElectronicoUsuarioOrUsuario(String cedula, String correo, String usuario);

}
