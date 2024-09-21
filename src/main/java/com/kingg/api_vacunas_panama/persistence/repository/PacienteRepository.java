package com.kingg.api_vacunas_panama.persistence.repository;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.web.dto.ViewPacienteVacunaEnfermedadDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Query(name = "view_paciente_vacuna_enfermedad", nativeQuery = true)
    List<ViewPacienteVacunaEnfermedadDto> findAllFromViewVacunaEnfermedad(@Param("cedula") String cedula);

}
