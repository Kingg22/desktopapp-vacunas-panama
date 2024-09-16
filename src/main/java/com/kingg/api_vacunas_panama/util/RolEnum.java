package com.kingg.api_vacunas_panama.util;

import lombok.Getter;

@Getter
public enum RolEnum {
    PACIENTE(1),
    FABRICANTE(2),
    ENFERMERA(3),
    DOCTOR(4),
    ADMINISTRATIVO(5),
    AUTORIDAD(6),
    DEVELOPER(7);

    private final int priority;

    RolEnum(int priority) {
        this.priority = priority;
    }

}
