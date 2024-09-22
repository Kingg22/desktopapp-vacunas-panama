package com.kingg.api_vacunas_panama.util;

import lombok.Getter;

@Getter
public enum RolesEnum {
    PACIENTE(1),
    FABRICANTE(2),
    ENFERMERA(3),
    DOCTOR(4),
    ADMINISTRATIVO(5),
    AUTORIDAD(6),
    DEVELOPER(7);

    private final int priority;

    RolesEnum(int priority) {
        this.priority = priority;
    }

}
