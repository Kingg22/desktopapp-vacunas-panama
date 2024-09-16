package com.kingg.api_vacunas_panama.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usuarios", indexes = {
        @Index(name = "uq_usuarios_cedula", columnList = "cedula", unique = true),
        @Index(name = "ix_usuarios_username", columnList = "usuario", unique = true),
        @Index(name = "ix_usuarios_email", columnList = "correo_usuario", unique = true)
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario", nullable = false)
    private UUID id;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Size(max = 50)
    @Nationalized
    @Column(name = "usuario", length = 50)
    private String username;

    @Size(max = 254)
    @Nationalized
    @Column(name = "correo_usuario", length = 254)
    private String correoUsuario;

    @Size(max = 60)
    @NotNull
    @Nationalized
    @Column(name = "clave_hash", nullable = false, length = 60)
    private String claveHash;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "last_used")
    private LocalDateTime lastUsed;

    @ManyToMany
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    @JsonManagedReference
    private Set<Rol> roles = new LinkedHashSet<>();

}