package logic.scanner_database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseInfo {
    Map<String, List<Column>> tablasColumnas = new HashMap<>();
    Map<String, List<Column>> vistasColumnas = new HashMap<>();
    Map<String, List<Column>> procedimientosColumnas = new HashMap<>();
    List<String> tablasNames = new ArrayList<>();
    List<String> vistasNames = new ArrayList<>();
    List<String> procedimientosNames = new ArrayList<>();

    // que realiza todas las operaciones de escanear la base de datos
    public DatabaseInfo(Connection conexion) throws SQLException {
        getTablesDynamic(conexion);
        getViewsDynamic(conexion);
        getProceduresDynamic(conexion);
    }

    // Métodos para explorar los objetos de la database
    private void getTablesDynamic(Connection conexion) throws SQLException {
        // filtrar las tablas creadas primero
        String query = "SELECT name FROM sys.tables WHERE is_ms_shipped = 0";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                tablasNames.add(resultSet.getString("name"));
            }
        }

        DatabaseMetaData meta = conexion.getMetaData();
        for (String tabla : tablasNames) {
            try (ResultSet rs = meta.getTables(null, null, tabla, new String[] { "TABLE" })) {
                rs.next();
                String tableName = rs.getString("TABLE_NAME");
                tablasColumnas.put(tableName, getColumnsDynamic(conexion, tableName));
            }

        }
    }

    private void getViewsDynamic(Connection conexion) throws SQLException {
        // filtrar las vistas personalizadas primero
        String query = "SELECT name FROM sys.views WHERE is_ms_shipped = 0";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                vistasNames.add(resultSet.getString("name"));
            }
        }
        // buscar el resto de información de las vistas
        DatabaseMetaData meta = conexion.getMetaData();
        for (String vista : vistasNames) {
            try (ResultSet rs = meta.getTables(null, null, vista, new String[] { "VIEW" })) {
                rs.next();
                String viewName = rs.getString("TABLE_NAME");
                vistasColumnas.put(viewName, getColumnsDynamic(conexion, viewName));

            }
        }
    }

    private void getProceduresDynamic(Connection conexion) throws SQLException {
        // filtrar los procedimientos personalizados primero
        String query = "SELECT name FROM sys.procedures WHERE is_ms_shipped = 0";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                procedimientosNames.add(resultSet.getString("name"));
            }
        }
        // buscar la información de los procedimientos personalizados
        DatabaseMetaData meta = conexion.getMetaData();
        for (String procedimiento : procedimientosNames) {
            try (ResultSet rs = meta.getProcedures(null, null, procedimiento)) {
                rs.next();
                String procedureName = rs.getString("PROCEDURE_NAME");
                procedimientosColumnas.put(procedureName, getProcedureColumnsDynamic(conexion, procedureName));

            }
        }
    }

    // método para recorrer de manera dinámica las tablas y vistas personalizadas
    private List<Column> getColumnsDynamic(Connection conexion, String tableName) throws SQLException {
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
    // personalizados
    private List<Column> getProcedureColumnsDynamic(Connection conexion, String tableName) throws SQLException {
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
     * public String toString() {
     * return "DatabaseInfo{" +
     * "tableColumns=" + tablasColumnas +
     * ", viewColumns=" + vistasColumnas +
     * ", proceduresColumns=" + procedimientosColumnas +
     * ", views= " + vistasNames +
     * ", tables= " + tablasNames +
     * ", procedimientos= " + procedimientosNames +
     * "}";
     * }
     */
}
