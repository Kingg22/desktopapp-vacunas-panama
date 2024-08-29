package logic.connexions;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerResultSetMetaData;
import logic.scanner_database.Column;
import logic.scanner_database.DatabaseInfo;
import logic.user_management.TokenMananger;
import logic.user_management.UserManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DatabaseOperaciones {
    private Connection connection = null;
    private int rol = Integer.MIN_VALUE;
    private String cedula = null;
    private DatabaseInfo databaseInfo = null;

    public static int getTipo(String rolUsuario) {
        int tipo;
        rolUsuario = rolUsuario.toLowerCase().trim();
        tipo = switch (rolUsuario) {
            case "paciente":
                yield 1;
            case "doctor - enfermera":
            case "doctor":
            case "enfermera":
                yield 2;
            case "administrativo":
                yield 3;
            case "fabricante":
                yield 4;
            case "administrador":
            case "admin":
                yield 5;
            case "autoridad":
                yield 6;
            case "app":
                yield 7;
            default:
                yield 0;
        };
        return tipo;
    }

    public static String getTipo(int tipo) {
        String tipoR;
        tipoR = switch (tipo) {
            case 1 -> "Paciente";
            case 2 -> "Doctor - Enfermera";
            case 3 -> "Administrativo";
            case 4 -> "Fabricante";
            case 5 -> "Administrador";
            case 6 -> "Autoridad";
            case 7 -> "App";
            default -> null;
        };
        return tipoR;
    }

    public static String getNumDosis(String numeroDosis) {
        String numDosis;
        numeroDosis = numeroDosis.toLowerCase().trim();
        numDosis = switch (numeroDosis) {
            case "primera dosis":
            case "primera":
            case "1":
            case "uno":
                yield "1";
            case "segunda dosis":
            case "segunda":
            case "2":
            case "dos":
                yield "2";
            case "tercera dosis":
            case "tercera":
            case "3":
            case "tres":
                yield "3";
            case "refuerzo":
            case "r":
                yield "R";
            case "primer refuerzo":
            case "refuerzo uno":
            case "refuerzo 1":
            case "r1":
                yield "R1";
            case "segundo refuerzo":
            case "refuerzo dos":
            case "refuerzo 2":
            case "r2":
                yield "R2";
            case "dosis previa":
            case "previa":
            case "p":
                yield "P";
            default:
                yield null;
        };
        return numDosis;
    }

    public synchronized Resultados selectAdmin(String token, String query, List<Object> params)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5 });
        if (query.matches("'(.*?)'")) {
            throw new CustomException(7, "Se ha encontrado ' ' dentro del query. No debe usar AS o similar.");
        }
        List<Object[]> resultados = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement) connection.prepareStatement(query);
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }
        processResult(pstmt, columns, columnasNombres, resultados);
        return new Resultados(columnasNombres.toArray(new String[0]), resultados.toArray(new Object[0][]));
    }

    public synchronized int processDML(String token, String query, List<Object> params)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5 });
        if (query.matches("'(.*?)'")) {
            throw new CustomException(7, "Se ha encontrado ' ' dentro del query. No debe usar AS o similar.");
        }
        SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement) connection.prepareStatement(query);
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }
        return countRowAffected(pstmt);
    }

    public synchronized DatabaseInfo getDB(String token) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6 });
        DatabaseInfo resp = databaseInfo;
        closeConnection();
        return resp;
    }

    public synchronized int insertarDosis(String token, String cedulaPaciente, Timestamp fechaAplicacion,
            String numero_dosis, int idVacuna, int idSede, String lote) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        try {
            SQLServerCallableStatement callstmt = (SQLServerCallableStatement) connection
                    .prepareCall("{call dbo.InsertarDosis(?, ?, ?, ?, ?, ?)}");
            callstmt.setString(1, cedulaPaciente);
            callstmt.setDateTime(2, fechaAplicacion);
            callstmt.setString(3, getNumDosis(numero_dosis));
            callstmt.setInt(4, idVacuna);
            callstmt.setInt(5, idSede);
            callstmt.setString(6, lote);
            return countRowAffected(callstmt);
        } finally {
            closeConnection();
        }
    }

    public synchronized Resultados showReporteVacunacionFiltrado(String token, int idSede)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        List<Object[]> resultados = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement(
                    """
                            SELECT CedulaPaciente, NombrePaciente, ApellidoPaciente, FechaNacimiento, Sexo, NombreVacuna, NumeroDosis\s
                            FROM [Reporte Vacunas Completo]\s
                            WHERE CONVERT(date, FechaAplicacion) = CONVERT(date, GETDATE()) AND IDSede = ?""");
            callStmt.setInt(1, idSede);
            processResult(callStmt, columns, columnasNombres, resultados);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultados.toArray(new Object[0][]));
    }

    public synchronized Resultados showLoteSedeVacuna(String token, String lote)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2, 3 });
        List<Object[]> resultList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement prepareStatement = (SQLServerPreparedStatement) connection.prepareStatement(
                    "SELECT [Nombre sede], [Depedencia sede], Vacuna, Cantidad, Lote, [Fecha Lote]  " +
                            "FROM [Sede - Inventario] \n" +
                            "WHERE Lote = ?");
            prepareStatement.setString(1, lote);
            processResult(prepareStatement, columns, columnasNombres, resultList);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultList.toArray(new Object[0][]));
    }

    public synchronized Resultados showSedeInventarioVacuna(String token, int idSede, int idVacuna)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        List<Object[]> resultList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement prepareStatement = (SQLServerPreparedStatement) connection.prepareStatement(
                    "SELECT *  FROM [Sede - Inventario] \n" +
                            "WHERE ID_Sede = ? AND [ID Vacuna] = ?");
            prepareStatement.setInt(1, idSede);
            prepareStatement.setInt(2, idVacuna);
            processResult(prepareStatement, columns, columnasNombres, resultList);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultList.toArray(new Object[0][]));
    }

    public synchronized Resultados showSedeInventario(String token, int idSede)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        List<Object[]> resultList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement prepareStatement = (SQLServerPreparedStatement) connection.prepareStatement(
                    "SELECT Vacuna, Cantidad, Lote, [Fecha Lote]  FROM [Sede - Inventario] \n" +
                            "WHERE ID_Sede = ?");
            prepareStatement.setInt(1, idSede);
            processResult(prepareStatement, columns, columnasNombres, resultList);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultList.toArray(new Object[0][]));
    }

    public synchronized Object[][] getDistritos(String token) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2, 3 });
        return executeQuery("SELECT d.distrito FROM Distrito d",
                new ArrayList<>(Collections.singleton(databaseInfo.getColumn("Distrito"))));
    }

    public synchronized Object[][] getSedes(String token) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2, 3 });
        return executeQuery("SELECT s.nombre_sede FROM Sede s",
                new ArrayList<>(Collections.singleton(databaseInfo.getColumn("nombre_sede"))));
    }

    public synchronized Object[][] getVacunas(String token) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        return executeQuery("SELECT v.nombre_vacuna FROM Vacuna v",
                new ArrayList<>(Collections.singleton(databaseInfo.getColumn("nombre_vacuna"))));
    }

    public synchronized int manipulatePaciente(String token, String cedula, String nombre, String apellido,
            Timestamp fechaNacimiento, char sexo, String telefono, String correo, String direccion, String distrito)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 7, 2 });
        try {
            SQLServerCallableStatement callstmt = (SQLServerCallableStatement) connection
                    .prepareCall("{call dbo.ManipularPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callstmt.setString(1, cedula);
            callstmt.setString(2, nombre);
            callstmt.setString(3, apellido);
            callstmt.setDateTime(4, fechaNacimiento);
            callstmt.setString(5, String.valueOf(sexo));
            callstmt.setString(6, telefono);
            callstmt.setString(7, correo);
            callstmt.setString(8, direccion);
            callstmt.setString(9, distrito);
            return countRowAffected(callstmt);
        } finally {
            closeConnection();
        }
    }

    public synchronized int manipulateUsuario(String token, String cedulaUsuario, String userUsuario,
            String passwordUsuarioHash, String rolUsuario, Timestamp fechaNacimientoUsuario)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 7 });
        int tipo = getTipo(rolUsuario);
        try {
            SQLServerCallableStatement callableStatement = (SQLServerCallableStatement) connection
                    .prepareCall("{call dbo.CrearUsuario(?, ?, ?, ?, ?)}");
            callableStatement.setString(1, cedulaUsuario);
            callableStatement.setString(2, userUsuario);
            callableStatement.setString(3, passwordUsuarioHash);
            callableStatement.setInt(4, tipo);
            callableStatement.setDateTime(5, fechaNacimientoUsuario);
            return countRowAffected(callableStatement);
        } finally {
            closeConnection();
        }
    }

    public synchronized Resultados searchUsuario(String token, String cedulaUsuario, String rolUsuario)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 7, 2 });
        int tipo = getTipo(rolUsuario);
        List<Object[]> resultList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement prepareStatement = (SQLServerPreparedStatement) connection
                    .prepareStatement("SELECT * FROM dbo.BuscarUsuario(?, ?)");
            prepareStatement.setString(1, cedulaUsuario);
            prepareStatement.setInt(2, tipo);
            processResult(prepareStatement, columns, columnasNombres, resultList);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultList.toArray(new Object[0][]));
    }

    public synchronized Resultados showUsuarios(String token) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 7 });
        List<Column> columns = databaseInfo.getColumnsForTable("Usuarios");
        String[] columnasNombres = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            columnasNombres[i] = columns.get(i).getName();
        }
        return new Resultados(columnasNombres, executeQuery(("SELECT * FROM [Usuarios]"), columns));
    }

    public synchronized boolean refreshAgePaciente(String token) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 1, 2, 3 });
        try {
            CallableStatement callStmt = connection.prepareCall("{call dbo.ActualizarEdadPacientes()}");
            return callStmt.execute();
        } finally {
            closeConnection();
        }
    }

    public synchronized Resultados searchTablePaciente(String token, String cedula, String nombreCompleto,
            String fechaNacimiento) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 7, 2, 3 });
        List<Column> columns = databaseInfo.getColumnsForTable("Paciente");
        columns.removeLast();
        columns.add(databaseInfo.getColumn("direccion"));
        columns.add(databaseInfo.getColumn("distrito"));
        String[] columnas = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            columnas[i] = columns.get(i).getName();
        }
        // Construcción de la consulta SQL dinámica
        StringBuilder sqlBuilder = new StringBuilder(
                "SELECT cedula, nombre_paciente, apellido_paciente, fecha_nacimiento, edad_calculada, sexo, " +
                        "telefono_paciente, correo_electronico_paciente, direccion, distrito " +
                        "FROM Paciente " +
                        "LEFT JOIN Direccion d ON idDireccion = d.ID_direccion " +
                        "LEFT JOIN Distrito dd ON d.idDistrito = dd.ID_distrito " +
                        "WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (cedula != null && !cedula.trim().isEmpty()) {
            sqlBuilder.append(" AND cedula = ?");
            params.add(cedula);
        }
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            sqlBuilder.append(" AND CONCAT(nombre_paciente, ' ', apellido_paciente) LIKE ?");
            params.add("%" + nombreCompleto + "%");
        }
        if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
            fechaNacimiento = String.valueOf(Date.valueOf(fechaNacimiento));
            sqlBuilder.append(" AND CAST(fecha_nacimiento AS DATE) = ?");
            params.add(fechaNacimiento);
        }
        SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement) connection
                .prepareStatement(sqlBuilder.toString());
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }
        return new Resultados(columnas, executePreparedQuery(pstmt, columns));
    }

    public synchronized Resultados searchPacienteDoctorView(String token, String cedula, String nombreCompleto,
            String fechaNacimiento) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 1, 2, 3 });
        List<Column> columns = databaseInfo.getColumnsForView("Vista Doctor");
        String[] columnas = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            columnas[i] = columns.get(i).getName();
        }
        // Construcción de la consulta SQL dinámica
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM [Vista Doctor] WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (cedula != null && !cedula.trim().isEmpty()) {
            sqlBuilder.append(" AND Cédula = ?");
            params.add(cedula);
        }
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            sqlBuilder.append(" AND CONCAT(Nombre, ' ', Apellido) LIKE ?");
            params.add("%" + nombreCompleto + "%");
        }
        if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
            fechaNacimiento = String.valueOf(Date.valueOf(fechaNacimiento));
            sqlBuilder.append(" AND CAST([Fecha de Nacimiento] AS DATE) = ?");
            params.add(fechaNacimiento);
        }
        SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement) connection
                .prepareStatement(sqlBuilder.toString());
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }
        return new Resultados(columnas, executePreparedQuery(pstmt, columns));
    }

    public synchronized Resultados buscarDosis(String token, String fechaInicio, String fechaFin, int idSede,
            int idVacuna, String numDosis) throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        List<Column> columns = databaseInfo.getColumnsForView("Vista Doctor");
        String[] columnas = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            columnas[i] = columns.get(i).getName();
        }
        StringBuilder query = new StringBuilder("SELECT * FROM [Vista Doctor] WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            fechaInicio = String.valueOf(Date.valueOf(fechaInicio));
            query.append(" AND CAST([Fecha de aplicación] AS DATE) >= ?");
            params.add(fechaInicio);
        }
        if (fechaFin != null && !fechaFin.isEmpty()) {
            fechaFin = String.valueOf(Date.valueOf(fechaFin));
            query.append(" AND CAST([Fecha de aplicación] AS DATE) <= ?");
            params.add(fechaFin);
        }
        if (idSede != -1) {
            query.append(" AND [ID Sede] = ?");
            params.add(idSede);
        }
        if (idVacuna != -1) {
            query.append(" AND [ID Vacuna] = ?");
            params.add(idVacuna);
        }
        if (numDosis != null && numDosis.length() <= 2 && !numDosis.isBlank()) {
            query.append(" AND [Número de dosis] = ?");
            params.add(numDosis);
        }
        SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement) connection.prepareStatement(query.toString());
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }
        return new Resultados(columnas, executePreparedQuery(pstmt, columns));
    }

    public synchronized Resultados showVistaOfPaciente(String token, String cedula)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 1 });
        List<Object[]> resultList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement prepareStatement = (SQLServerPreparedStatement) connection.prepareStatement(
                    "SELECT [Nombre Vacuna], [Número de dosis], [Enfermedad previene], [Fecha de aplicación], Sede, Dependencia "
                            +
                            "FROM [Vista Paciente] " +
                            "WHERE Cédula = ?");
            prepareStatement.setString(1, cedula);
            processResult(prepareStatement, columns, columnasNombres, resultList);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultList.toArray(new Object[0][]));
    }

    public synchronized Resultados showVistaDoctorInSede(String token, int idSede)
            throws SQLException, ClassNotFoundException {
        verifyAccess(token, new int[] { 5, 6, 2 });
        List<Object[]> resultList = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<String> columnasNombres = new ArrayList<>();
        try {
            SQLServerPreparedStatement prepareStatement = (SQLServerPreparedStatement) connection.prepareStatement(
                    """
                            SELECT Cédula, Nombre, Apellido, [Fecha de Nacimiento], [Edad], Sexo, Teléfono, \
                            [Correo electrónico], [Dirección residencia actual], Distrito, Provincia, [Nombre vacuna], \
                            Fabricante, [Fecha de aplicación], Sede, Dependencia, [Número de dosis], \
                            [Intervalo dosis 1 y 2 recomendado en meses], [Intervalo real en días], [Edad mínima recomendada en meses]\s
                            FROM [Vista Doctor]\s
                            WHERE [ID Sede] = ?""");
            prepareStatement.setInt(1, idSede);
            processResult(prepareStatement, columns, columnasNombres, resultList);
        } finally {
            closeConnection();
        }
        return new Resultados(columnasNombres.toArray(new String[0]), resultList.toArray(new Object[0][]));
    }

    // métodos privados para la clase funcionar
    private synchronized void switchUser() throws SQLException, ClassNotFoundException {
        Conexion.closeConnection(connection);
        this.connection = Conexion.getConnection(getTipo(rol));
        this.databaseInfo = new DatabaseInfo(connection);
        System.out.println(executeUpdate(
                "UPDATE Usuarios SET last_used = CURRENT_TIMESTAMP WHERE cedula = '" + cedula + "' AND tipo = " + rol)
                + " last used of CIP: '" + cedula + "' rol: '" + getTipo(rol) + "' update!");
    }

    private synchronized void closeConnection() throws SQLException {
        cedula = null;
        rol = Integer.MIN_VALUE;
        databaseInfo = null;
        Conexion.closeConnection(connection);
    }

    private synchronized Object[][] executeQuery(String query, List<Column> columns) throws SQLException {
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
        return resultList.toArray(new Object[0][]);
    }

    private synchronized Object[][] executePreparedQuery(SQLServerPreparedStatement preparedStatement,
            List<Column> columns) throws SQLException {
        if (columns == null || columns.isEmpty()) {
            throw new SQLException("No se tienen columnas para recibir resultados.");
        }
        List<Object[]> resultList = new ArrayList<>();
        try (SQLServerResultSet resultSet = (SQLServerResultSet) preparedStatement.executeQuery()) {
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
        return resultList.toArray(new Object[0][]);
    }

    private synchronized int executeUpdate(String query) throws SQLException {
        int result;
        try (SQLServerPreparedStatement preparedStatement = (SQLServerPreparedStatement) connection
                .prepareStatement(query)) {
            result = countRowAffected(preparedStatement);
        } finally {
            if (!query.startsWith("UPDATE Usuarios SET last_used"))
                closeConnection();
        }
        return result;
    }

    private synchronized Resultados selectComplete(int tipo, String name) throws SQLException {
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
            if (columnasLista != null && query != null && !query.isBlank()) {
                String[] column = new String[columnasLista.size()];
                for (int i = 0; i < columnasLista.size(); i++) {
                    column[i] = columnasLista.get(i).getName();
                }
                resultados = new Resultados(column, executeQuery(query, columnasLista));
            } else
                throw new SQLException("No se encontró objeto que coincida.");
        }
        return resultados;
    }

    private String searchName(int type, String pattern) {
        List<String> names;
        if (pattern == null || pattern.trim().isEmpty()) {
            return null;
        }
        switch (type) {
            case 1:
                names = new ArrayList<>(databaseInfo.getTablasNombres());
                break;
            case 2:
                names = new ArrayList<>(databaseInfo.getVistasNombres());
                break;
            case 3:
                names = new ArrayList<>(databaseInfo.getProcedimientosNombres());
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

    private int countRowAffected(SQLServerPreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement.execute()) {
            throw new CustomException(8, "El statement quiere ser procesado como count y se obtuvo un resultSet.");
        } else {
            int count = 0;
            count += preparedStatement.getUpdateCount();
            while (!preparedStatement.getMoreResults()) {
                int updateCount = preparedStatement.getUpdateCount();
                if (updateCount == -1) {
                    // No hay más resultados
                    break;
                }
                count += updateCount;
            }
            return count;
        }
    }

    private void processResult(SQLServerPreparedStatement statement, List<Column> columns, List<String> columnasNombres,
            List<Object[]> resultList) throws SQLException {
        if (!statement.execute()) {
            throw new CustomException(8, "El statement quiere ser procesado como resultSet y se obtuvo un count.");
        } else {
            SQLServerResultSet resultSet = (SQLServerResultSet) statement.getResultSet();
            SQLServerResultSetMetaData metaData = (SQLServerResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                boolean isNullable = metaData.isNullable(i) == ResultSetMetaData.columnNullable;
                columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i),
                        metaData.getColumnDisplaySize(i), isNullable, metaData.isAutoIncrement(i)));
                columnasNombres.add(metaData.getColumnName(i));
            }
            boolean hasResult = true;
            while (hasResult) {
                while (resultSet.next()) {
                    Object[] row = new Object[columns.size()];
                    for (int i = 0; i < columns.size(); i++) {
                        row[i] = getColumnValueDynamic(resultSet, columns.get(i));
                    }
                    resultList.add(row);
                }
                hasResult = statement.getMoreResults();
            }
        }
    }

    private boolean verifyToken(String token) throws JWTVerificationException {
        if (TokenMananger.verifyToken(token)) {
            rol = TokenMananger.getRoleFromToken(token);
            cedula = TokenMananger.getCedulaFromToken(token);
            return true;
        }
        return false;
    }

    private void verifyAccess(String token, int[] rolRequerido) throws SQLException, ClassNotFoundException {
        if (token == null) {
            throw new CustomException(0, "Debe tener un token registrado para ejecutar un comando.");
        }
        if (rolRequerido.length == 0) {
            throw new SQLException("Programador: Debe definir roles autorizados para este comando.");
        }
        try {
            if (verifyToken(token)) {
                if (rol == Integer.MIN_VALUE) {
                    throw new CustomException(3, "No hay rol definido en el token usado.");
                }
                if (cedula == null) {
                    throw new CustomException(4, "No hay usuario en el token usado.");
                }
                if (UserManager.buscar(cedula, getTipo(rol)) == null) {
                    throw new CustomException(1,
                            "No hay usuario registrado de forma local con el rol del token usado.");
                }
                boolean access = false;
                for (int j : rolRequerido) {
                    if (rol == j) {
                        access = true;
                        break;
                    }
                }
                if (access) {
                    switchUser();
                    if (connection == null)
                        throw new CustomException(2,
                                "No se obtuvo conexión a la base de datos sin errores. Acceso denegado.");
                } else
                    throw new CustomException(5, "NO tiene permiso para ejecutar este comando.");
            }
        } catch (JWTVerificationException e) {
            throw new CustomException(6, e);
        }
    }

    // getters
    public String getRol() {
        return getTipo(rol);
    }

    public String getCedula() {
        return cedula;
    }
}