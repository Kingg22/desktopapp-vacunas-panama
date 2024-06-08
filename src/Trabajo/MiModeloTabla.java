package Trabajo;

import Trabajo.Conexions.DatabaseOperaciones;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.SQLException;
/*
public class MiModeloTabla extends AbstractTableModel {
    private static DatabaseOperaciones db;
    private String[][] data;
    private String[] columnNames;

    static {
        try {
            db = new DatabaseOperaciones();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error en frame interno: " + e.getMessage());
        }
    }

    public MiModeloTabla(String vista) throws Exception {
        actualizarDatos(vista);
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    public void actualizarDatos(String vista) throws Exception {
        switch (vista) {
            case "pac" -> db.queryViewPaciente();
            case "doc" -> db.queryViewDoctor();
            case "prov" -> db.queryViewProveedor();
            case "admin" -> db.queryViewAdmin();
        }
        data = db.getResultadosArray();
        columnNames = db.getColumnasArray();
    }
    // getters y setters
    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public static DatabaseOperaciones getDb() {
        return db;
    }

    public static void setDb(DatabaseOperaciones db) {
        MiModeloTabla.db = db;
    }
}*/