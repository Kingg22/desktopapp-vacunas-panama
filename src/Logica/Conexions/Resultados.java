package Logica.Conexions;

public class Resultados {
    String[] columnas;
    Object[][] datos;

    public Resultados(String[] columnas, Object[][] datos) {
        this.columnas = columnas;
        this.datos = datos;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public String[] getColumnas() {
        return columnas;
    }
}
