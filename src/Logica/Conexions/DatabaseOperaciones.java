package Logica.Conexions;

import Logica.ScannerDatabase.Column;
import Logica.ScannerDatabase.DatabaseInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseOperaciones {
    private Connection connection = null;
    private String usuarioActual = null;
    private DatabaseInfo databaseInfo = null;

    public DatabaseOperaciones() throws SQLException, ClassNotFoundException {
        // Por defecto, iniciar con el rol "admin"
        cambiarUsuario("admin");
    }

    public void cambiarUsuario(String rol) throws SQLException, ClassNotFoundException {
        // Cerrar la conexión actual si existe
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
        this.connection = Conexion.getConnection(rol);
        databaseInfo = new DatabaseInfo(connection);
        this.usuarioActual = rol;
    }

    public List<String[]> query(int tipo, String name) throws SQLException {
        if (tipo > 4 || tipo < 1 || name == null) {
            throw new SQLException("Tipo de objeto no valido para query. " +
                    "\nPermitidos 1= tablas 2= vistas 3= procedimientos" +
                    "\nNombre de objeto debe estar lo más cerca posible. " +
                    "\nIntente nuevamente.");
        }
        List<String[]> resultados = new ArrayList<>();

        String tabla = searchName(tipo, name);
        if (tabla != null) {
            String query = null;
            List<Column> columnasLista = null;
            switch (tipo) {
                case 1:
                    query = "SELECT * FROM " + tabla;
                    columnasLista = databaseInfo.getColumnsForTable(tabla);
                    break;
                case 2:
                    query = "SELECT * FROM [" + tabla + "]";
                    columnasLista = databaseInfo.getColumnsForView(tabla);
                    break;
                case 3:
                    query = ""; // PROCEDIMIENTOS POR IMPLEMENTAR
                    columnasLista = databaseInfo.getColumnsForProcedure(tabla);
                    break;
            }
            if (columnasLista != null && query != null || query.isBlank()) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String[] resultado = new String[columnasLista.size()];
                        int i = -1;
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
        } else
            throw new SQLException("No se encontró objeto que coincida.");

        return resultados;
    }

    private String searchName(int type, String pattern) {
        List<String> names = null;
        if (pattern == null || pattern.trim().isEmpty()) {
            return null;
        }
        switch (type) {
            case 1:
                names = new ArrayList<>(databaseInfo.getTablasNames());
                break;
            case 2:
                names = new ArrayList<>(databaseInfo.getVistasNames());
                break;
            case 3:
                names = new ArrayList<>(databaseInfo.getProcedimientosNames());
                break;
            default:
                return null;
        }
        // Primero buscar coincidencia exacta
        Optional<String> exactMatch = names.stream()
                .filter(name -> name.equalsIgnoreCase(pattern))
                .findFirst();

        if (exactMatch.isPresent()) {
            return exactMatch.get();
        }

        // Luego buscar por coincidencia parcial (ignorando mayúsculas y minúsculas)
        Optional<String> partialMatch = names.stream()
                .filter(name -> name.toLowerCase().contains(pattern.toLowerCase()))
                .findFirst();

        return partialMatch.orElse(null);
        /*
        for (String tabla : names) {
            if (tabla.equalsIgnoreCase(pattern)) {
                return tabla;
            }
        }

        for (String tabla : names) {
            if (tabla.toLowerCase().contains(pattern.toLowerCase())) {
                return tabla;
            }
        }
        return null; */
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