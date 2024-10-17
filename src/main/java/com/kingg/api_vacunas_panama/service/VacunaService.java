package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.configuration.RabbitMQConfiguration;
import com.kingg.api_vacunas_panama.persistence.entity.*;
import com.kingg.api_vacunas_panama.persistence.repository.DosisRepository;
import com.kingg.api_vacunas_panama.persistence.repository.PacientesDosisRepository;
import com.kingg.api_vacunas_panama.persistence.repository.VacunaRepository;
import com.kingg.api_vacunas_panama.util.mapper.DosisMapper;
import com.kingg.api_vacunas_panama.web.dto.DosisDto;
import com.kingg.api_vacunas_panama.web.dto.InsertDosisDto;
import com.kingg.api_vacunas_panama.web.dto.VacunaFabricanteDto;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Service for {@link Vacuna}, {@link Dosis} and {@link PacientesDosis}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VacunaService {
    private final RabbitTemplate rabbitTemplate;
    private final DosisMapper dosisMapper;
    private final VacunaRepository vacunaRepository;
    private final DosisRepository dosisRepository;
    private final PacientesDosisRepository pacientesDosisRepository;
    private final PacienteService pacienteService;
    private final SedeService sedeService;
    private final DoctorService doctorService;

    @Cacheable(cacheNames = "huge", key = "'vacunas'")
    public List<VacunaFabricanteDto> getVacunas() {
        return vacunaRepository.findAllIdAndNombreAndFabricante();
    }

    @Transactional
    public DosisDto createDosis(@NotNull InsertDosisDto insertDosisDto) throws IllegalStateException, IllegalArgumentException, NoSuchElementException {
        log.debug(insertDosisDto.toString());
        Paciente paciente = validatePacienteExist(insertDosisDto.pacienteId());
        Vacuna vacuna = validateVacunaExist(insertDosisDto.vacunaId());
        Sede sede = validateSedeExist(insertDosisDto.sedeId());
        Doctor doctor = validateDoctorExist(insertDosisDto.doctorId());
        log.debug("Paciente ID: {}", paciente.getId());
        log.debug("Vacuna ID: {}", vacuna.getId());
        log.debug("Sede ID: {}", sede.getId());
        this.pacientesDosisRepository.findTopByPacienteAndDosis_VacunaOrderByCreatedAtDesc(paciente, vacuna).ifPresent(
                ultimaDosis -> {
                    if (ultimaDosis.getDosis() != null) {
                        log.debug("Dosis encontrada ID: {}", ultimaDosis.getDosis().getId());
                        if (!ultimaDosis.getDosis().getNumeroDosis().isValidNew(insertDosisDto.numeroDosis())) {
                            throw new IllegalArgumentException("La dosis ".concat(insertDosisDto.numeroDosis().toString()).concat(" no es válida. ")
                                    .concat("Último número de dosis ".concat(ultimaDosis.getDosis().getNumeroDosis().toString())));
                        }
                        log.debug("Nueva dosis cumple las reglas de secuencia en número de dosis");
                    } else {
                        log.debug("El paciente no tiene dosis previa de la vacuna a aplicar");
                    }
                });

        Dosis dosis = Dosis.builder()
                .fechaAplicacion(insertDosisDto.fechaAplicacion() != null ? insertDosisDto.fechaAplicacion() : LocalDateTime.now(ZoneOffset.UTC))
                .numeroDosis(insertDosisDto.numeroDosis())
                .vacuna(vacuna)
                .sede(sede)
                .lote(insertDosisDto.lote())
                .doctor(doctor)
                .createdAt(LocalDateTime.now(ZoneOffset.UTC))
                .build();
        dosis = dosisRepository.save(dosis);
        dosis = dosisRepository.findById(dosis.getId()).orElseThrow();
        log.debug("Nueva dosis. ID: {}", dosis.getId());

        // TODO corregir persistencia de pk compuesta
        PacientesDosisId pacientesDosisId = new PacientesDosisId();
        pacientesDosisId.setIdDosis(dosis.getId());
        pacientesDosisId.setIdPaciente(paciente.getId());

        PacientesDosis pacientesDosis = new PacientesDosis();
        pacientesDosis.setId(pacientesDosisId);
        pacientesDosis.setPaciente(paciente);
        pacientesDosis.setDosis(dosis);
        pacientesDosis.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        pacientesDosisRepository.save(pacientesDosis);

        DosisDto dosisDto = dosisMapper.toDto(dosis);

        rabbitTemplate.convertAndSend(RabbitMQConfiguration.QUEUE_DOSIS, dosisDto);

        return dosisDto;
    }

    public DosisDto getDosisById(UUID idDosis) {
        return dosisMapper.toDto(dosisRepository.findById(idDosis).orElseThrow());
    }

    public List<DosisDto> getDosisByPacienteId(UUID idPaciente) {
        return pacientesDosisRepository.findAllByPaciente_Id(idPaciente).stream()
                .map(pacientesDosis -> dosisMapper.toDto(pacientesDosis.getDosis()))
                .toList();
    }

    Paciente validatePacienteExist(UUID pacienteId) {
        return this.pacienteService.getPacienteById(pacienteId).orElseThrow(() -> new NoSuchElementException("Paciente no encontrado"));
    }

    Vacuna validateVacunaExist(UUID vacunaId) {
        return this.vacunaRepository.findById(vacunaId).orElseThrow(() -> new NoSuchElementException("Vacuna no encontrada"));
    }

    Sede validateSedeExist(UUID sedeId) {
        return this.sedeService.getSedeById(sedeId).orElseThrow(() -> new NoSuchElementException("Sede no encontrado"));
    }

    Doctor validateDoctorExist(UUID doctorId) {
        if (doctorId != null) {
            return this.doctorService.getDoctorById(doctorId).orElseThrow(() -> new NoSuchElementException("Doctor no encontrado"));
        }
        return null;
    }

}
