package com.kingg.api_vacunas_panama.services;

import com.kingg.api_vacunas_panama.dto.DireccionDto;
import com.kingg.api_vacunas_panama.dto.PacienteDto;
import com.kingg.api_vacunas_panama.entity.Paciente;
import com.kingg.api_vacunas_panama.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Optional<PacienteDto> getPacienteByCedula(String cedula) {
        return pacienteRepository.findById(cedula).map(this::pacienteToDTO);
    }

    private PacienteDto pacienteToDTO(Paciente paciente) {
        return new PacienteDto(
                paciente.getCedula(),
                paciente.getNombrePaciente(),
                paciente.getApellido1Paciente(),
                paciente.getApellido2Paciente(),
                paciente.getFechaNacimiento(),
                paciente.getEdadCalculada(),
                paciente.getSexo(),
                paciente.getTelefonoPaciente(),
                paciente.getCorreoElectronicoPaciente(),
                new DireccionDto(
                    paciente.getIdDireccion().getId(),
                    paciente.getIdDireccion().getDireccion(),
                    paciente.getIdDireccion().getIdDistrito().getId(),
                    paciente.getIdDireccion().getIdDistrito().getNombreDistrito(),
                    paciente.getIdDireccion().getIdDistrito().getIdProvincia().getId(),
                    paciente.getIdDireccion().getIdDistrito().getIdProvincia().getNombreProvincia()
                )
        );
    }
}
