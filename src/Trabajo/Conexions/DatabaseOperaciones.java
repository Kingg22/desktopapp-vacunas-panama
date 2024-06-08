package Trabajo.Conexions;

import Trabajo.ScannerDatabase.Column;
import Trabajo.ScannerDatabase.DatabaseInfo;

import java.sql.*;
import java.util.*;

public class DatabaseOperaciones {
    private Connection connection = null;
    private String usuarioActual = null;
    private DatabaseInfo databaseInfo;

    public DatabaseOperaciones(Connection connection) throws SQLException, ClassNotFoundException {
        // Por defecto, iniciar con el usuario "pac"
        cambiarUsuario("pac");
        this.databaseInfo = new DatabaseInfo().scan(connection);
    }

    public void cambiarUsuario(String rol) throws SQLException, ClassNotFoundException {
        // Cerrar la conexión actual si existe
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
        // Obtener una nueva conexión con el usuario especificado en el servidor

        // IMPLEMENTAR ROLES DE LA DATABASE
        this.connection = Conexion.getConnection(rol);
        this.usuarioActual = rol;
    }

    public List<String[]> queryView(String tipo) throws SQLException {
        List<String[]> resultados = new ArrayList<>();

        String tabla = buscarTabla(tipo);
        if (tabla != null) {
            List<Column> columnasLista = databaseInfo.getColumnsForView("Vista " + tabla);
            String query = "SELECT * FROM [" + tabla + "]";
            if (columnasLista != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String[] resultado = new String[columnasLista.size()];
                        int i= -1;
                        for (Column column : columnasLista) {
                            i++;
                            resultado[i] = getColumnValueDynamic(resultSet, column);
                        }
                        resultados.add(resultado);
                    }
                } finally {
                    closeConnection();
                }
            }
        }

        return resultados;
    }

    private String buscarTabla(String pattern) {
        List<String> tablas = databaseInfo.getTablasNames();

        for (String tabla : tablas) {
            if (tabla.equalsIgnoreCase(pattern)) {
                return tabla;
            }
        }

        for(String tabla : tablas) {
            if(tabla.toLowerCase().contains(pattern.toLowerCase())) {
                return tabla;
            }
        }
        return null;
    }

    private String getColumnValueDynamic(ResultSet resultSet, Column column) throws SQLException {
        String columnName = column.getName();
        String columnType = column.getType();
        switch (columnType.toUpperCase()) {
            case "VARCHAR":
            case "CHAR":
            case "TEXT":
                return resultSet.getString(columnName);
            case "INT":
            case "INTEGER":
                return String.valueOf(resultSet.getInt(columnName));
            case "FLOAT":
            case "REAL":
            case "DOUBLE":
                return String.valueOf(resultSet.getDouble(columnName));
            case "BOOLEAN":
                return String.valueOf(resultSet.getBoolean(columnName));
            case "DATE":
                return String.valueOf(resultSet.getDate(columnName));
            case "TIME":
                return String.valueOf(resultSet.getTime(columnName));
            case "TIMESTAMP":
            case "DATETIME":
                // Obtener el valor TIMESTAMP o DATETIME como un objeto Timestamp
                Timestamp timestampValue = resultSet.getTimestamp(columnName);
                // Convertir el objeto Timestamp a String
                return (timestampValue != null) ? timestampValue.toString() : null;
            default:
                return resultSet.getString(columnName); // Default to String if type is unknown
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}