package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.web.dto.ViewPacienteVacunaEnfermedadDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

    @Query(name = "Paciente.getVacunaEnfermedades", nativeQuery = true)
    List<ViewPacienteVacunaEnfermedadDto> findAllFromViewVacunaEnfermedad(@Param("id") UUID id);

    @Query("SELECT p " +
            "FROM Paciente p " +
            "WHERE (:cedula IS NOT NULL AND p.cedula = :cedula) OR " +
            "(:pasaporte IS NOT NULL AND p.pasaporte = :pasaporte) OR " +
            "(:idTemporal IS NOT NULL AND p.identificacionTemporal = :idTemporal) OR " +
            "(:correo IS NOT NULL AND p.correo = :correo) OR " +
            "(:username IS NOT NULL AND p.usuario.username = :username)")
    Optional<Paciente> findByCedulaOrPasaporteOrIdTemporalOrCorreoOrUsername(@Param("cedula") String cedula, @Param("pasaporte") String pasaporte, @Param("idTemporal") String idTemporal, @Param("correo") String correo, @Param("username") String username);

    Optional<Paciente> findByIdentificacionTemporal(String idTemporal);

}
