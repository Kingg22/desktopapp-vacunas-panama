package Logica.Conexions;

public class Resultados {
    String[] columnas;
    Object[][] datos;
    int[] columnasWidth;

    public Resultados(String[] columnas, int[] columnasWidth, Object[][] datos) {
        this.columnas = columnas;
        this.columnasWidth = columnasWidth;
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

    public int[] getColumnasWidth() {
        return columnasWidth;
    }
}
