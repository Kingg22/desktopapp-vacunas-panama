import Logica.Conexions.DatabaseOperaciones;
import Logica.Validations.InicioSesion;

import java.sql.Timestamp;

public class Prueba {
    public static void main(String[] args) {
        try {
            InicioSesion is = new InicioSesion();
            DatabaseOperaciones db = new DatabaseOperaciones();
            //Resultados resulto = db.buscarDosis("admin", "admin1234", "Administrador", null, null, -1, -1, null);
            /*for (Object nombre : result)
                System.out.println(nombre);
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
            } */
            System.out.println(db.manipulatePaciente("admin", "admin1234", "Administrador", "8-1006-14", "pruebas", "prueba", Timestamp.valueOf("2005-12-12 00:00:00"), 'M', null, null, null, null) + " rows affected.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
