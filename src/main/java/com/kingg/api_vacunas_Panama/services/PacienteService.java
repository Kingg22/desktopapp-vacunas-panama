package com.kingg.api_vacunas_Panama.services;

import com.kingg.api_vacunas_Panama.dto.DireccionDTO;
import com.kingg.api_vacunas_Panama.dto.PacienteDTO;
import com.kingg.api_vacunas_Panama.entity.Paciente;
import com.kingg.api_vacunas_Panama.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Optional<PacienteDTO> getPacienteByCedula(String cedula) {
        return pacienteRepository.findById(cedula).map(this::pacienteToDTO);
    }

    private PacienteDTO pacienteToDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO(
                paciente.getCedula(),
                paciente.getNombrePaciente(),
                paciente.getApellidoPaciente(),
                paciente.getSexo(),
                paciente.getEdadCalculada(),
                paciente.getFechaNacimiento(),
                paciente.getTelefonoPaciente(),
                paciente.getCorreoElectronicoPaciente()
        );

        if (paciente.getIdDireccion() != null) {
            DireccionDTO direccionDTO = new DireccionDTO(
                    paciente.getIdDireccion().getDireccion(),
                    paciente.getIdDireccion().getIdDistrito().getDistrito(),
                    paciente.getIdDireccion().getIdDistrito().getIdProvincia().getProvincia()
            );

            pacienteDTO.setDireccion(direccionDTO);
        }
        return pacienteDTO;
    }
}
