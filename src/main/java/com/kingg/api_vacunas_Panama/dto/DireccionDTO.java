package com.kingg.api_vacunas_Panama.dto;

public class DireccionDTO {
    private String direccion;
    private String distrito;
    private String provincia;

    public DireccionDTO() {

    }


    public String getDireccion() {
        return direccion;
    }

    public DireccionDTO(String direccion, String distrito, String provincia) {
        this.direccion = direccion;
        this.distrito = distrito;
        this.provincia = provincia;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
