import Logica.Conexions.DatabaseOperaciones;
import Logica.Validations.InicioSesion;

public class Prueba {
    public static void main(String[] args) {
        try {
            InicioSesion is = new InicioSesion();
            DatabaseOperaciones db = new DatabaseOperaciones();
            Object[] result = db.getDistritos("admin", "admin1234", "Administrador");
            for (Object nombre : result)
                System.out.println(nombre);
            /*if (result != Integer.MIN_VALUE) {
                // Recorrer cada columna
                String[] columna = resulto.getColumnas();
                Object[][] data = resulto.getDatos();
                for (String column : columna) {
                    System.out.print(column + " | ");
                }
                for (int i = 0; i < data.length; i++) {
                    System.out.println("\nFila " + (i + 1) + ":");
                    for (int j = 0; j < columna.length; j++) {
                        System.out.print(data[i][j] + " | ");
                    }
                }
            }*/
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
