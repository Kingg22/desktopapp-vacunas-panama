package Logica.Conexions;

import Logica.ScannerDatabase.Column;
import Logica.ScannerDatabase.DatabaseInfo;
import Logica.Validations.InicioSesion;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DatabaseOperaciones {
    private Connection connection = null;
    private String usuarioActual = null;
    private DatabaseInfo databaseInfo = null;
    private boolean adminCreateBD = false;

    public void switchUser(String rol) throws SQLException, ClassNotFoundException {
        // Cerrar la conexión actual si existe
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
        this.connection = Conexion.getConnection(rol);
        databaseInfo = new DatabaseInfo(connection);
        this.usuarioActual = rol;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
    }

    public String[] getDistritos(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            Object[][] data = execute("SELECT d.distrito FROM Distrito d", new ArrayList<>(Collections.singleton(new Column("distrito", "VARCHAR", 50, false))));
            String[] resultados = new String[data.length];
            for (int i = 0; i < data.length; i++) {
                resultados[i] = (String) data[i][0];
            }
            return resultados;
        }
    }

    public int manipulatePaciente(String user, String password, String rol, String cedula, String nombre, String apellido, Timestamp fechaNacimiento, char sexo, String telefono, String correo, String direccion, String distrito) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            throw new SQLException("NO estas registrado para ejecutar un comando. TIMEOUT");
        } else {
            if (!rol.equals("Proveedor") && !rol.equals("Paciente")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            try {
                SQLServerCallableStatement callstmt = (SQLServerCallableStatement) connection.prepareCall("{call dbo.ManipularPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                callstmt.setString(1, cedula);
                callstmt.setString(2, nombre);
                callstmt.setString(3, apellido);
                callstmt.setDateTime(4, fechaNacimiento);
                callstmt.setString(5, String.valueOf(sexo));
                callstmt.setString(6, telefono);
                callstmt.setString(7, correo);
                callstmt.setString(8, direccion);
                callstmt.setString(9, distrito);
                return callstmt.executeUpdate();
            } finally {
                closeConnection();
            }
        }
    }

    public boolean insertDosis(String user, String password, String rol, String cedula, Timestamp fechaAplicacion, int ID_Sede, int ID_Vacuna, char numero_dosis) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return false;
        } else {
            if (rol.equals("Doctor - Enfermera") || rol.equals("Administrador")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            try {
                SQLServerCallableStatement callstmt = (SQLServerCallableStatement) connection.prepareCall("{call dbo.CrearDosis (?, ?, ?, ?, ?)}");
                callstmt.setString(1, cedula);
                callstmt.setDateTime(2, fechaAplicacion);
                callstmt.setString(3, String.valueOf(numero_dosis));
                callstmt.setInt(4, ID_Vacuna);
                callstmt.setInt(5, ID_Sede);
                return callstmt.execute();
            } finally {
                closeConnection();
            }
        }
    }

    public int manipulateUsuario(String user, String password, String rol, String cedulaUsuario, String userUsuario, String passwordUsuarioHash, String rolUsuario, Timestamp fechaNacimientoUsuario) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return Integer.MIN_VALUE;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            int tipo = getTipo(rolUsuario);
            try {
                SQLServerCallableStatement callableStatement = (SQLServerCallableStatement) connection.prepareCall("{call dbo.CrearUsuario(?, ?, ?, ?, ?)}");
                callableStatement.setString(1, cedulaUsuario);
                callableStatement.setString(2, userUsuario);
                callableStatement.setString(3, passwordUsuarioHash);
                callableStatement.setInt(4, tipo);
                callableStatement.setDateTime(5, fechaNacimientoUsuario);
                return callableStatement.executeUpdate();
            } finally {
                closeConnection();
            }
        }
    }

    public int createAdminBD(String cedulaAdmin, String userAdmin, String passwordAdminHash, Timestamp fechaNacimientoAdmin) throws SQLException, ClassNotFoundException {
        if (!adminCreateBD) {
            switchUser("administrador");
            if (connection == null) {
                throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
            }
            try {
                SQLServerCallableStatement callableStatement = (SQLServerCallableStatement) connection.prepareCall("{call dbo.CrearUsuario(?, ?, ?, ?, ?)}");
                callableStatement.setString(1, cedulaAdmin);
                callableStatement.setString(2, userAdmin);
                callableStatement.setString(3, passwordAdminHash);
                callableStatement.setInt(4, 5);
                callableStatement.setDateTime(5, fechaNacimientoAdmin);
                return callableStatement.executeUpdate();
            } finally {
                closeConnection();
                adminCreateBD = true;
            }
        } else {
            throw new SQLException("NO se puede ejecutar este comando más de 1 vez. TIMEOUT - BAN USER");
        }
    }

    public Resultados searchUsuario(String user, String password, String rol, String cedulaUsuario, String rolUsuario) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            int tipo = getTipo(rolUsuario);
            List<Object[]> resultList = new ArrayList<>();
            List<Column> columns = new ArrayList<>();
            String[] columnas = new String[3];
            try {
                PreparedStatement callStmt = connection.prepareStatement("SELECT * FROM dbo.BuscarUsuario(?, ?)");
                callStmt.setString(1, cedulaUsuario);
                callStmt.setInt(2, tipo);
                boolean ejecutado = callStmt.execute();
                if (ejecutado) {
                    SQLServerResultSet resultSet = (SQLServerResultSet) callStmt.getResultSet();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i)));
                    }
                    while (resultSet.next()) {
                        Object[] row = new Object[columns.size()];
                        for (int i = 0; i < columns.size(); i++) {
                            columnas[i] = columns.get(i).getName();
                            row[i] = getColumnValueDynamic(resultSet, columns.get(i));
                        }
                        resultList.add(row);
                    }
                } else {
                    throw new SQLException("Hubo un error al buscar el usuario en la base de datos.");
                }
            } finally {
                closeConnection();
            }
            /*
            String[][] result = new String[resultList.size()][columnas.length];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }*/
            return new Resultados(columnas, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados showUsuarios(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForTable("Usuarios");
            return new Resultados(new String[columns.size()], execute(("SELECT * FROM [Usuarios]"), columns));
        }
    }

    public boolean refreshAgePaciente(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return false;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol);
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            try {
                CallableStatement callS = connection.prepareCall("{call dbo.ActualizarEdadPacientes()}");
                return callS.execute();
            } finally {
                closeConnection();
            }
        }
    }

    public Resultados showPacientes(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Proveedor")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            return selectComplete(1, "Paciente");
        }
    }

    public Resultados searchPaciente(String user, String password, String rol, String cedula) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Proveedor")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForTable("Paciente");
            String[] columnas = new String[columns.size()];
            int i = -1;
            for (Column columna : columns) {
                i++;
                columnas[i] = columna.getName();
            }
            return new Resultados(columnas, execute("SELECT * FROM Paciente WHERE cedula = '" + cedula + "'", columns));
        }
    }

    public Resultados showVistaPaciente(String user, String password, String rol, String cedula) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Proveedor")) {
                switchUser(rol);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForView("Vista Paciente");
            while (!columns.getFirst().getName().equals("Nombre vacuna")) {
                columns.removeFirst();
            }
            String query = "SELECT ";
            String[] column = new String[columns.size()];
            int i = -1;
            for (Column columnas : columns) {
                i++;
                query += "p.[" + columnas.getName() + "], ";
                column[i] = columnas.getName();
            }
            query = query.substring(0, query.length() - 2); // eliminar la última coma
            return new Resultados(column, execute((query + " FROM [Vista Paciente] p WHERE p.Cédula = '" + cedula + "'"), columns));
        }
    }

    private Object[][] execute(String query, List<Column> columns) throws SQLException {
        if (columns == null || columns.isEmpty()) {
            throw new SQLException("No se tienen columnas para recibir resultados.");
        }

        List<Object[]> resultList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             SQLServerResultSet resultSet = (SQLServerResultSet) preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Object[] row = new Object[columns.size()];
                for (int i = 0; i < columns.size(); i++) {
                    row[i] = getColumnValueDynamic(resultSet, columns.get(i));
                }
                resultList.add(row);
            }
        } finally {
            closeConnection();
        }
        /*
        Object[][] result = new Object[resultList.size()][columnas.length];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }*/
        return resultList.toArray(new Object[0][]);
    }

    private Resultados selectComplete(int tipo, String name) throws SQLException {
        if (tipo > 4 || tipo < 1 || name == null) {
            throw new SQLException("""
                    Tipo de objeto no valido para query. \

                    Permitidos 1= tablas 2= vistas 3= procedimientos\

                    Nombre de objeto debe estar lo más cerca posible. \

                    Intente nuevamente.""");
        }
        Resultados resultados = null;

        String object = searchName(tipo, name);
        String query = null;
        List<Column> columnasLista = null;
        if (object != null) {
            columnasLista = switch (tipo) {
                case 1 -> {
                    query = "SELECT * FROM " + object;
                    yield databaseInfo.getColumnsForTable(object);
                }
                case 2 -> {
                    query = "SELECT * FROM [" + object + "]";
                    yield databaseInfo.getColumnsForView(object);
                }
                case 3 -> {
                    query = "call dbo." + object + "()";
                    yield databaseInfo.getColumnsForProcedure(object);
                }
                default -> columnasLista;
            };
            if (columnasLista != null && query != null || query.isBlank()) {
                String[] column = new String[columnasLista.size()];
                int i = -1;
                for (Column columnas : columnasLista) {
                    i++;
                    column[i] = columnas.getName();
                }
                resultados = new Resultados(column, execute(query, columnasLista));
            } else
                throw new SQLException("No se encontró objeto que coincida.");
        }
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
    }

    private Object getColumnValueDynamic(SQLServerResultSet resultSet, Column column) throws SQLException {
        String columnName = column.getName();
        String columnType = column.getType();
        return switch (columnType.toUpperCase()) {
            case "VARCHAR", "CHAR", "TEXT" -> resultSet.getString(columnName);
            case "INT", "INTEGER" -> resultSet.getInt(columnName);
            case "FLOAT", "REAL", "DOUBLE" -> resultSet.getDouble(columnName);
            case "BOOLEAN" -> resultSet.getBoolean(columnName);
            case "DATE" -> resultSet.getDate(columnName);
            case "TIME" -> resultSet.getTime(columnName);
            case "TIMESTAMP" -> resultSet.getTimestamp(columnName);
            case "DATETIME" -> resultSet.getDateTime(columnName);
            default -> resultSet.getObject(columnName); // Default to Object if type is unknown
        };
    }

    private static int getTipo(String rolUsuario) throws SQLException {
        int tipo;
        tipo = switch (rolUsuario) {
            case "Paciente" -> 1;
            case "Doctor - Enfermera" -> 2;
            case "Administrativo" -> 3;
            case "Fabricante" -> 4;
            case "Administrador" -> 5;
            case "Autoridad" -> 6;
            default -> 0;
        };
        if (tipo == 0) {
            throw new SQLException("Rol del usuario no expected. TIMEOUT");
        }
        return tipo;
    }

    public static String getTipo(int tipo) throws SQLException {
        String tipoR;
        tipoR = switch (tipo) {
            case 1 -> "Paciente";
            case 2 -> "Doctor - Enfermera";
            case 3 -> "Administrativo";
            case 4 -> "Fabricante";
            case 5 -> "Administrador";
            case 6 -> "Autoridad";
            default -> null;
        };
        if (tipoR == null) {
            throw new SQLException("Rol del usuario no expected. TIMEOUT");
        }
        return tipoR;
    }

    // getters
    public Connection getConnection() {
        return connection;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public DatabaseInfo getDatabaseInfo() {
        return databaseInfo;
    }
}