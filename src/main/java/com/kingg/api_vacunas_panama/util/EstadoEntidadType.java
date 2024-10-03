package com.kingg.api_vacunas_panama.util;

import lombok.Getter;

@Getter
public enum EstadoEntidadType {
    ACTIVO(false),
    NO_VALIDADO(true),
    INACTIVO(false),
    DESACTIVADO(true);

    private final boolean disabled;

    EstadoEntidadType(boolean disabled) {
        this.disabled = disabled;
    }
}
