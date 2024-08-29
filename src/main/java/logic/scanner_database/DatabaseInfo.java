package logic.scanner_database;

import com.microsoft.sqlserver.jdbc.SQLServerDatabaseMetaData;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DatabaseInfo {
    Map<String, List<Column>> tablasColumnas = new HashMap<>();
    Map<String, List<Column>> vistasColumnas = new HashMap<>();
    Map<String, List<Column>> procedimientosColumnas = new HashMap<>();
    Map<String, List<Column>> funcionesColumnas = new HashMap<>();
    Map<String, List<String>> objetosColumnasNombres = new HashMap<>();
    Map<String, List<String>> columnasAutoIncrementada = new HashMap<>();
    List<Column> objetosColumnas = new ArrayList<>();
    List<String> tablasNombres = new ArrayList<>();
    List<String> vistasNombres = new ArrayList<>();
    List<String> procedimientosNombres = new ArrayList<>();
    List<String> funcionesNombres = new ArrayList<>();
    List<String> funcionesTablaNombres = new ArrayList<>();

    // escanear la base de datos según la conexión dada
    public DatabaseInfo(Connection conexion) throws SQLException {
        getTablesDynamic(conexion);
        getViewsDynamic(conexion);
        getProceduresDynamic(conexion);
        getFunctionsDynamic(conexion);
        Map<String, List<Column>>[] objects = new Map[] { tablasColumnas, vistasColumnas };
        for (Map<String, List<Column>> m : objects) {
            for (String object2 : m.keySet()) {
                List<String> columnasTable = new ArrayList<>();
                for (Column columna : m.get(object2)) {
                    if (columna.isAutoIncrement())
                        columnasTable.add(columna.getName());
                }
                columnasAutoIncrementada.put(object2, columnasTable);
            }
        }
        if (getTablasNombres().contains("Sede"))
            columnasAutoIncrementada.get("Sede").add("region");
        if (getTablasNombres().contains("Paciente"))
            columnasAutoIncrementada.get("Paciente").add("edad_calculada");
    }

    // Métodos para explorar los objetos de la database
    private void getTablesDynamic(Connection conexion) throws SQLException {
        // filtrar las tablas creadas primero
        String query = "SELECT name FROM sys.tables WHERE is_ms_shipped = 0";
        try (SQLServerPreparedStatement preparedStatement = (SQLServerPreparedStatement) conexion
                .prepareStatement(query);
                SQLServerResultSet resultSet = (SQLServerResultSet) preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                tablasNombres.add(resultSet.getString("name"));
            }
        }

        SQLServerDatabaseMetaData meta = (SQLServerDatabaseMetaData) conexion.getMetaData();
        for (String tabla : tablasNombres) {
            try (SQLServerResultSet rs = (SQLServerResultSet) meta.getTables(null, null, tabla,
                    new String[] { "TABLE" })) {
                rs.next();
                String tableName = rs.getString("TABLE_NAME");
                tablasColumnas.put(tableName, getColumnsDynamic(conexion, tableName));
            }
        }
    }

    private void getViewsDynamic(Connection conexion) throws SQLException {
        // filtrar las vistas personalizadas primero
        String query = "SELECT name FROM sys.views WHERE is_ms_shipped = 0";
        try (SQLServerPreparedStatement preparedStatement = (SQLServerPreparedStatement) conexion
                .prepareStatement(query);
                SQLServerResultSet resultSet = (SQLServerResultSet) preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                vistasNombres.add(resultSet.getString("name"));
            }
        }
        // buscar el resto de información de las vistas
        DatabaseMetaData meta = conexion.getMetaData();
        for (String vista : vistasNombres) {
            try (SQLServerResultSet rs = (SQLServerResultSet) meta.getTables(null, null, vista,
                    new String[] { "VIEW" })) {
                rs.next();
                String viewName = rs.getString("TABLE_NAME");
                vistasColumnas.put(viewName, getColumnsDynamic(conexion, viewName));
            }
        }
    }

    private void getProceduresDynamic(Connection conexion) throws SQLException {
        // filtrar los procedimientos personalizados primero
        String query = "SELECT name FROM sys.procedures WHERE is_ms_shipped = 0";
        try (SQLServerPreparedStatement preparedStatement = (SQLServerPreparedStatement) conexion
                .prepareStatement(query);
                SQLServerResultSet resultSet = (SQLServerResultSet) preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                procedimientosNombres.add(resultSet.getString("name"));
            }
        }
        // buscar la información de los procedimientos personalizados
        SQLServerDatabaseMetaData meta = (SQLServerDatabaseMetaData) conexion.getMetaData();
        for (String procedimiento : procedimientosNombres) {
            try (ResultSet rs = meta.getProcedures(null, null, procedimiento)) {
                rs.next();
                String procedureName = rs.getString("PROCEDURE_NAME");
                procedimientosColumnas.put(procedimiento, getProcedureColumnsDynamic(conexion, procedureName));
            }
        }
    }

    private void getFunctionsDynamic(Connection conexion) throws SQLException {
        String query = "SELECT name FROM sys.objects WHERE type IN ('FN', 'IF', 'TF') AND is_ms_shipped = 0";
        try (SQLServerPreparedStatement preparedStatement = (SQLServerPreparedStatement) conexion
                .prepareStatement(query);
                SQLServerResultSet resultSet = (SQLServerResultSet) preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                funcionesNombres.add(resultSet.getString("name"));
            }
        }
        // buscar la información de las funciones personalizadas
        SQLServerDatabaseMetaData meta = (SQLServerDatabaseMetaData) conexion.getMetaData();
        for (String funcion : funcionesNombres) {
            try (ResultSet rs = meta.getFunctions(null, null, funcion)) {
                rs.next();
                String functionName = rs.getString("FUNCTION_NAME");
                short functionType = rs.getShort("FUNCTION_TYPE");
                funcionesColumnas.put(funcion, getFunctionColumnsDynamic(conexion, functionName));
                if (functionType == 2)
                    funcionesTablaNombres.add(functionName);
            }
        }
    }

    // método para recorrer de manera dinámica las tablas y vistas personalizadas
    private List<Column> getColumnsDynamic(Connection conexion, String tableName) throws SQLException {
        List<Column> columnas = new ArrayList<>();
        List<String> columnasNames = new ArrayList<>();

        SQLServerResultSet rs = (SQLServerResultSet) conexion.getMetaData().getColumns(null, null, tableName, "%");
        while (rs.next()) {
            Column column = process(rs, columnasNames);
            boolean isAutoincremente = rs.getString("IS_AUTOINCREMENT").equals("YES");
            column.setAutoIncrement(isAutoincremente);
            column.setSize(rs.getInt("COLUMN_SIZE"));
            String defaultValue = rs.getString("COLUMN_DEF");
            column.setDefaultValue(defaultValue);
            columnas.add(column);
        }
        objetosColumnasNombres.put(tableName, columnasNames);
        tablasColumnas.put(tableName, columnas);
        objetosColumnas.addAll(columnas);
        return columnas;
    }

    // método para recorrer de manera dinámica los procedimientos almacenados
    // personalizados
    private List<Column> getProcedureColumnsDynamic(Connection conexion, String procedureName) throws SQLException {
        List<Column> columnas = new ArrayList<>();
        List<String> columnasNames = new ArrayList<>();

        SQLServerResultSet rs = (SQLServerResultSet) conexion.getMetaData().getProcedureColumns(null, null,
                procedureName, "%");
        while (rs.next()) {
            Column column = process(rs, columnasNames);
            column.setSize(rs.getInt("PRECISION"));
            column.setDefaultValue(rs.getString("COLUMN_DEF"));
            column.setPosition(rs.getInt("ORDINAL_POSITION"));
            columnas.add(column);
        }
        objetosColumnasNombres.put(procedureName, columnasNames);
        objetosColumnas.addAll(columnas);
        return columnas;
    }

    // método para recorrer de manera dinámica las funciones personalizadas
    private List<Column> getFunctionColumnsDynamic(Connection conexion, String functionName) throws SQLException {
        List<Column> columnas = new ArrayList<>();
        List<String> columnasNames = new ArrayList<>();

        SQLServerResultSet rs = (SQLServerResultSet) conexion.getMetaData().getFunctionColumns(null, null, functionName,
                "%");
        while (rs.next()) {
            Column column = process(rs, columnasNames);
            column.setSize(rs.getInt("PRECISION"));
            column.setPosition(rs.getInt("ORDINAL_POSITION"));
            columnas.add(column);
        }
        objetosColumnasNombres.put(functionName, columnasNames);
        objetosColumnas.addAll(columnas);
        return columnas;
    }

    // método para guardar los datos obtenidos
    private Column process(SQLServerResultSet rs, List<String> columnasNames) throws SQLException {
        String columnName = rs.getString("COLUMN_NAME");
        String columnType = rs.getString("TYPE_NAME");
        boolean isNullable = rs.getString("IS_NULLABLE").equals("YES");
        columnasNames.add(columnName);
        return new Column(columnName, columnType, isNullable);
    }

    // getters
    public List<Column> getColumnsForTable(String tableName) {
        return tablasColumnas.get(tableName);
    }

    public List<Column> getColumnsForView(String viewName) {
        return vistasColumnas.get(viewName);
    }

    public List<Column> getColumnsForProcedure(String procedureName) {
        return procedimientosColumnas.get(procedureName);
    }

    public List<Column> getColumnsForFunction(String functionName) {
        return funcionesColumnas.get(functionName);
    }

    public List<String> getTablasNombres() {
        return tablasNombres;
    }

    public List<String> getVistasNombres() {
        return vistasNombres;
    }

    public List<String> getProcedimientosNombres() {
        return procedimientosNombres;
    }

    public List<String> getFuncionesNombres() {
        return funcionesNombres;
    }

    public List<String> getFuncionesTablaNombres() {
        return funcionesTablaNombres;
    }

    public List<String> getColumnsNombres(String object) {
        return objetosColumnasNombres.get(object);
    }

    public List<String> getColumnsIdentity(String object) {
        return columnasAutoIncrementada.get(object);
    }

    public Column getColumn(String columnName) {
        return objetosColumnas.stream()
                .filter(column -> column.getName().equals(columnName))
                .findFirst()
                .orElse(null);
    }

    public boolean containReturnColumn(String objectName) {
        return getColumnsForFunction(objectName).stream()
                .anyMatch(column -> column.getName().startsWith("@RETURN"));
    }

    public String getLastTable() {
        return tablasNombres.getLast();
    }

    public String getLastView() {
        return vistasNombres.getLast();
    }

    public String getLastProcedure() {
        return procedimientosNombres.getLast();
    }

    public String getLastFunction() {
        return funcionesNombres.getLast();
    }

    public List<Column> getObjetosColumnas() {
        return objetosColumnas;
    }

    public Map<String, List<Column>> getTablasColumnas() {
        return tablasColumnas;
    }

    public Map<String, List<Column>> getVistasColumnas() {
        return vistasColumnas;
    }

    public Map<String, List<Column>> getFuncionesColumnas() {
        return funcionesColumnas;
    }

    public Map<String, List<Column>> getProcedimientosColumnas() {
        return procedimientosColumnas;
    }

    public Map<String, List<String>> getColumnasAutoIncrementada() {
        return columnasAutoIncrementada;
    }

    public Map<String, List<String>> getObjetosColumnasNombres() {
        return objetosColumnasNombres;
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
