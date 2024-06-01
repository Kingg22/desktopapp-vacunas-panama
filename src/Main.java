import Trabajo.*;

import javax.swing.JOptionPane;
import java.io.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // variables para JOPTION
        String[] option1 = {"Paciente", "Medico", "Proveedor", "Administrador MINSA"};
        // variables
        String[][] salida;
        String[] salida2;
        String impresion = "";
        int entrada = -1;
        // objetos
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // objeto de sql
        DatabaseOperaciones operacion = null;
        try {
            operacion = new DatabaseOperaciones();
        } catch (Exception e) {
            System.err.println("Error al iniciar operaciones con BD " + e.getMessage());
        }

        try {
            entrada = JOptionPane.showOptionDialog(null, "Escoja una opción de vista:",
                    "MINSA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, option1, null);
        } catch (Exception i) {
            System.out.println("Error en el menu 1: " + i);
        }
        switch (entrada) {
            case 0: // paciente
                try {
                    operacion.queryViewPaciente();
                    System.out.println("Conexión exitosa");
                } catch (Exception s) {
                    System.err.println("Error en la operación: " + s);
                } finally {
                    try {
                        operacion.closeConnection();
                        System.out.println("Conexión cerrada con éxito");
                    } catch (SQLException s) {
                        System.err.println("Error al cerrar la conexión de Pacientes " + s.getMessage());
                    }
                }
                salida = operacion.getResultados();
                for(String[] fila : salida) {
                    for(String element : fila) {
                        impresion += element + " ";
                    }
                    impresion += "\n";
                }
                JOptionPane.showMessageDialog(null, impresion, "Vista Paciente",JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }
}
