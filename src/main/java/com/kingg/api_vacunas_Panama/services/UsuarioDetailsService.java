package com.kingg.api_vacunas_panama.services;

import com.kingg.api_vacunas_panama.entity.Usuario;
import com.kingg.api_vacunas_panama.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByCedulaOrCorreoElectronicoUsuarioOrUsuario(identifier, identifier, identifier);

        if (usuario.isPresent()) {
            Usuario user = usuario.get();
            Collection<GrantedAuthority> authorities = user.getRoles()
                    .stream()
                    .flatMap(role -> Stream.concat(
                            Stream.of(new SimpleGrantedAuthority("ROLE_" + role.getNombreRol().toUpperCase())),
                            role.getPermisos()
                                    .stream()
                                    .map(permiso -> new SimpleGrantedAuthority(permiso.getNombrePermiso().toUpperCase()))
                    )).collect(Collectors.toSet());

            return User.withUsername(user.getCedula())
                        .password(user.getClaveHash())
                        .authorities(authorities)
                        .disabled(user.getDisabled())
                        .build();
        }
        throw new UsernameNotFoundException("User not found");
    }

}
