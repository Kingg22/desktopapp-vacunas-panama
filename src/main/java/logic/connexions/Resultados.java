package logic.connexions;

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object[] row : datos) {
            for (Object col : row) {
                sb.append(col).append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
