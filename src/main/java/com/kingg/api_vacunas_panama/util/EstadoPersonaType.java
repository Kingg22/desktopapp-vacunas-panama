package com.kingg.api_vacunas_panama.util;

import lombok.Getter;

@Getter
public enum EstadoPersonaType {
    ACTIVO(false),
    NO_VALIDADO(true),
    FALLECIDO(true),
    INACTIVO(false),
    DESACTIVADO(true);

    private final boolean disabled;

    EstadoPersonaType(boolean disabled) {
        this.disabled = disabled;
    }

}
