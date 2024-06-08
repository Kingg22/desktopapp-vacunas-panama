import Trabajo.Conexions.Conexion;
import Trabajo.Conexions.DatabaseOperaciones;

import java.util.List;

public class PruebasDinamicas {
    public static void main(String[] args) {
        try {
            DatabaseOperaciones db = new DatabaseOperaciones();
            List<String[]> result = db.query(2, "Vista Paciente");
            System.out.println("Vista Paciente");
            for (String[] row : result) {
                System.out.print(row[0]);
                for (int i = 1; i < row.length; i++) {
                    System.out.print("\t" + row[i]);
                }
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
