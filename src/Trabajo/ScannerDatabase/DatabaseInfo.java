package Trabajo.ScannerDatabase;

import java.sql.*;
import java.util.*;

public class DatabaseInfo {
    Map<String, List<Column>> tablasColumnas = new HashMap<>();
    Map<String, List<Column>> vistasColumnas = new HashMap<>();
    Map<String, List<Column>> procedimientosColumnas = new HashMap<>();
    List<String> tablasNames = new ArrayList<>();
    List<String> vistasNames = new ArrayList<>();
    List<String> procedimientosNames = new ArrayList<>();

    // método tipo constructor que realiza todas las operaciones y devuelve el objeto de la clase para obtener la información.
    public DatabaseInfo scan(Connection conexion) throws SQLException {
        DatabaseInfo dbInfo = new DatabaseInfo();
        dbInfo.getTablesDynamic(conexion);
        dbInfo.getViewsDynamic(conexion);
        dbInfo.getProceduresDynamic(conexion);
        return dbInfo;
    }
    // Métodos para explorar los objetos de la database
    List<String> getTablesDynamic(Connection conexion) throws SQLException {
        List<String> tablas = new ArrayList<String>();
        ResultSet rs;
        DatabaseMetaData meta = conexion.getMetaData();
        rs = meta.getTables(null, null, "%", new String[]{"TABLE"});
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            tablas.add(tableName);
            tablasColumnas.put(tableName, getColumnsDynamic(conexion, tableName));
        }
        this.tablasNames = tablas;
        return tablas;
    }

    List<String> getViewsDynamic(Connection conexion) throws SQLException {
        List<String> vistas = new ArrayList<>();
        ResultSet rs;
        DatabaseMetaData meta = conexion.getMetaData();
        rs = meta.getTables(null, null, "%", new String[]{"VIEW"});
        while (rs.next()) {
            String viewName = rs.getString("TABLE_NAME");
            vistas.add(viewName);
            vistasColumnas.put(viewName, getColumnsDynamic(conexion, viewName));
        }
        this.vistasNames = vistas;
        return vistas;
    }

    List<String> getProceduresDynamic(Connection conexion) throws SQLException {
        List<String> procedimientos = new ArrayList<>();
        ResultSet rs;
        DatabaseMetaData meta = conexion.getMetaData();
        rs = meta.getProcedures(null, null, "%");
        while (rs.next()) {
            String procedureName = rs.getString("PROCEDURE_NAME");
            procedimientos.add(procedureName);
            procedimientosColumnas.put(procedureName, getProcedureColumnsDynamic(conexion, procedureName));
        }
        this.procedimientosNames = procedimientos;
        return procedimientos;
    }
    // método para recorrer de manera dinámica las tablas y vistas
    List<Column> getColumnsDynamic(Connection conexion, String tableName) throws SQLException {
        List<Column> columnas = new ArrayList<>();

        ResultSet rs = conexion.getMetaData().getColumns(null, null, tableName, "%");
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            String columnType = rs.getString("TYPE_NAME");
            int columnSize = rs.getInt("COLUMN_SIZE");
            boolean isNullable = rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
            columnas.add(new Column(columnName, columnType, columnSize, isNullable));
        }
        return columnas;
    }
    // método para recorrer de manera dinámica los procedimientos almacenados
    List<Column> getProcedureColumnsDynamic(Connection conexion, String tableName) throws SQLException {
        List<Column> columnas = new ArrayList<>();

        ResultSet rs = conexion.getMetaData().getProcedureColumns(null, null, tableName, "%");
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            String columnType = rs.getString("TYPE_NAME");
            int columnSize = rs.getInt("PRECISION");
            boolean isNullable = rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
            columnas.add(new Column(columnName, columnType, columnSize, isNullable));
        }
        return columnas;
    }
    // getters
    public Map<String, List<Column>> getTablasColumnas() {
        return tablasColumnas;
    }

    public Map<String, List<Column>> getVistasColumnas() {
        return vistasColumnas;
    }

    public Map<String, List<Column>> getProcedimientosColumnas() {
        return procedimientosColumnas;
    }

    public List<Column> getColumnsForTable(String tableName) {
        return tablasColumnas.get(tableName);
    }

    public List<Column> getColumnsForView(String viewName) {
        return vistasColumnas.get(viewName);
    }

    public List<Column> getColumnsForProcedure(String procedureName) {
        return procedimientosColumnas.get(procedureName);
    }

    public List<String> getTablasNames() {
        return tablasNames;
    }

    public List<String> getVistasNames() {
        return vistasNames;
    }

    public List<String> getProcedimientosNames() {
        return procedimientosNames;
    }

    /*
    public String toString() {
        return "DatabaseInfo{" +
                "tableColumns=" + tablasColumnas +
                ", viewColumns=" + vistasColumnas +
                ", proceduresColumns=" + procedimientosColumnas +
                ", views= " + vistasNames +
                ", tables= " + tablasNames +
                ", procedimientos= " + procedimientosNames +
                "}";
    } */
}
