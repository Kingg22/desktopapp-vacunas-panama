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

    public Resultados showReporteVacunacionFiltrado(String user, String password, String rol, int idSede) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Paciente") && !rol.equals("Proveedor")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            List<Object[]> resultList = new ArrayList<>();
            List<Column> columns = new ArrayList<>();
            String[] columnas = new String[7];
            try {
                PreparedStatement callStmt = connection.prepareStatement("SELECT CedulaPaciente, NombrePaciente, ApellidoPaciente, FechaNacimiento, Sexo, NombreVacuna, NumeroDosis \nFROM [Reporte Vacunas Completo] \nWHERE CONVERT(date, FechaAplicacion) = CONVERT(date, GETDATE()) AND IDSede = ?");
                callStmt.setInt(1, idSede);
                ResultSet resultSet = callStmt.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i)));
                }
                for (int i = 0; i < columns.size(); i++)
                    columnas[i] = columns.get(i).getName();
                while (resultSet.next()) {
                    Object[] row = new Object[columns.size()];
                    for (int i = 0; i < columns.size(); i++) {
                        row[i] = getColumnValueDynamic((SQLServerResultSet) resultSet, columns.get(i));
                    }
                    resultList.add(row);
                }
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados showSedeInventario(String user, String password, String rol, int idSede) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Paciente")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            List<Object[]> resultList = new ArrayList<>();
            List<Column> columns = new ArrayList<>();
            String[] columnas = new String[4];
            try {
                PreparedStatement callStmt = connection.prepareStatement("SELECT Vacuna, Cantidad, Lote, [Fecha Lote]  FROM [Sede - Inventario] \nWHERE ID_Sede = ?");
                callStmt.setInt(1, idSede);
                ResultSet resultSet = callStmt.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i)));
                }
                for (int i = 0; i < columns.size(); i++)
                    columnas[i] = columns.get(i).getName();
                while (resultSet.next()) {
                    Object[] row = new Object[columns.size()];
                    for (int i = 0; i < columns.size(); i++) {
                        row[i] = getColumnValueDynamic((SQLServerResultSet) resultSet, columns.get(i));
                    }
                    resultList.add(row);
                }
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, resultList.toArray(new Object[0][]));
        }
    }

    public Object[][] getDistritos(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            return executeQuery("SELECT d.distrito FROM Distrito d", new ArrayList<>(Collections.singleton(new Column("distrito", "VARCHAR", 50, true))));
        }
    }

    public Object[][] getSedes(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            return executeQuery("SELECT s.nombre_sede FROM Sede s", new ArrayList<>(Collections.singleton(new Column("nombre_sede", "VARCHAR", 100, false))));
        }
    }

    public Object[][] getVacunas(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            return executeQuery("SELECT v.nombre_vacuna FROM Vacuna v", new ArrayList<>(Collections.singleton(new Column("nombre_vacuna", "VARCHAR", 100, false))));
        }
    }

    public int manipulatePaciente(String user, String password, String rol, String cedula, String nombre, String apellido, Timestamp fechaNacimiento, char sexo, String telefono, String correo, String direccion, String distrito) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            throw new SQLException("NO estas registrado para ejecutar un comando. TIMEOUT");
        } else {
            if (!rol.equals("Proveedor") && !rol.equals("Paciente")) {
                switchUser(rol, user);
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
                int count = callstmt.executeUpdate();
                count += callstmt.getUpdateCount();
                while (!callstmt.getMoreResults()) {
                    if (callstmt.getUpdateCount() == -1) {
                        break;
                    }
                    count += callstmt.getUpdateCount();
                }
                return count;
                //return callstmt.executeUpdate();
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
                switchUser(rol, user);
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
                switchUser(rol, user);
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
            switchToAdmin();
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
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            int tipo = getTipo(rolUsuario);
            List<Object[]> resultList = new ArrayList<>();
            List<Column> columns = new ArrayList<>();
            String[] columnas = new String[5];
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
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso de ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForTable("Usuarios");
            return new Resultados(new String[columns.size()], executeQuery(("SELECT * FROM [Usuarios]"), columns));
        }
    }

    public boolean refreshAgePaciente(String user, String password, String rol) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return false;
        } else {
            if (rol.equals("Administrador")) {
                switchUser(rol, user);
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
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            return selectComplete(1, "Paciente");
        }
    }

    public Resultados searchPaciente(String user, String password, String rol, String cedula, String nombreCompleto, String fechaNacimiento) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Proveedor")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForView("Vista Doctor");
            String[] columnas = new String[columns.size()];
            int i = -1;
            for (Column columna : columns) {
                i++;
                columnas[i] = columna.getName();
            }
            // Construcción de la consulta SQL dinámica
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM [Vista Doctor] WHERE 1=1");

            if (cedula != null && !cedula.trim().isEmpty()) {
                sqlBuilder.append(" AND Cédula = '" + cedula + "'");
            }
            if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
                sqlBuilder.append(" AND [Nombre Completo] LIKE '" + nombreCompleto + "'");
            }
            if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
                fechaNacimiento = String.valueOf(Date.valueOf(fechaNacimiento));
                sqlBuilder.append(" AND CAST([Fecha de Nacimiento] AS DATE) = '" + fechaNacimiento + "'");
            }
            return new Resultados(columnas, executeQuery(sqlBuilder.toString(), columns));
        }
    }

    public Resultados showVistaPaciente(String user, String password, String rol, String cedula) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Paciente") || rol.equals("Administrador") || rol.equals("Autoridad")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Object[]> resultList = new ArrayList<>();
            List<Column> columns = new ArrayList<>();
            String[] columnas = new String[6];
            try {
                PreparedStatement callStmt = connection.prepareStatement("SELECT [Nombre Vacuna], [Número de dosis], [Enfermedad previene], [Fecha de aplicación], Sede, Dependencia \nFROM [Vista Paciente] \nWHERE Cédula = ?");
                callStmt.setString(1, cedula);
                ResultSet resultSet = callStmt.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i)));
                }
                for (int i = 0; i < columns.size(); i++)
                    columnas[i] = columns.get(i).getName();
                while (resultSet.next()) {
                    Object[] row = new Object[columns.size()];
                    for (int i = 0; i < columns.size(); i++) {
                        row[i] = getColumnValueDynamic((SQLServerResultSet) resultSet, columns.get(i));
                    }
                    resultList.add(row);
                }
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados showVistaDoctor(String user, String password, String rol, int idSede) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (rol.equals("Doctor - Enfermera") || rol.equals("Administrador") || rol.equals("Autoridad")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Object[]> resultList = new ArrayList<>();
            List<Column> columns = new ArrayList<>();
            String[] columnas = new String[17];
            try {
                PreparedStatement callStmt = connection.prepareStatement("SELECT Cédula, Nombre, Apellido, [Fecha de Nacimiento], [Edad calculada], Sexo, Teléfono, [Correo electrónico], [Dirección residencia actual], Distrito, Provincia, [Nombre vacuna], Fabricante, [Fecha de aplicación], [Número de dosis], [Intervalo dosis 1 y 2 recomendado en meses], [Intervalo real en días] \nFROM [Vista Doctor] \nWHERE [ID Sede] = ?");
                callStmt.setInt(1, idSede);
                ResultSet resultSet = callStmt.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i)));
                }
                for (int i = 0; i < columns.size(); i++)
                    columnas[i] = columns.get(i).getName();
                while (resultSet.next()) {
                    Object[] row = new Object[columns.size()];
                    for (int i = 0; i < columns.size(); i++) {
                        row[i] = getColumnValueDynamic((SQLServerResultSet) resultSet, columns.get(i));
                    }
                    resultList.add(row);
                }
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados buscarDosis(String user, String password, String rol, String fechaInicio, String fechaFin, int idSede, int idVacuna, String numDosis) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Proveedor")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForView("Vista Doctor");
            String[] columnas = new String[columns.size()];
            int i = -1;
            for (Column columna : columns) {
                i++;
                columnas[i] = columna.getName();
            }

            StringBuilder query = new StringBuilder("SELECT * FROM [Vista Doctor] WHERE 1=1");

            if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
                fechaInicio = String.valueOf(Date.valueOf(fechaInicio));
                query.append(" AND CAST([Fecha de aplicación] AS DATE) >= '" + fechaInicio + "'");
            }
            if (fechaFin != null && !fechaFin.isEmpty()) {
                fechaFin = String.valueOf(Date.valueOf(fechaFin));
                query.append(" AND CAST([Fecha de aplicación] AS DATE) <= '" + fechaFin + "'");
            }
            if (idSede != -1) {
                query.append(" AND [ID Sede] = " + idSede);
            }
            if (idVacuna != -1) {
                query.append(" AND [ID Vacuna] = " + idVacuna);
            }
            if (numDosis != null && numDosis.length() <= 2 && !numDosis.isBlank()) {
                query.append(" AND [Número de dosis] = '" + numDosis + "'");
            }
            return new Resultados(columnas, executeQuery(query.toString(), columns));
        }
    }

    // métodos privados para la clase funcionar
    private void switchUser(String rol, String user) throws SQLException, ClassNotFoundException {
        // Cerrar la conexión actual si existe
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
        this.connection = Conexion.getConnection(rol);
        databaseInfo = new DatabaseInfo(connection);
        this.usuarioActual = rol;
        executeUpdate("UPDATE Usuarios \nSET last_used = CURRENT_TIMESTAMP \nWHERE usuario = '" + user + "' AND tipo = " + getTipo(rol));
    }

    private void switchToAdmin() throws SQLException, ClassNotFoundException {
        if (adminCreateBD) {
            throw new SQLException("NO se puede ejecutar este método más de 1 vez y fuera de esta clase. TIMEOUT - BAN USER");
        }
        // Cerrar la conexión actual si existe
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
        this.connection = Conexion.getConnection("administrador");
        databaseInfo = new DatabaseInfo(connection);
        this.usuarioActual = "administrador";
    }

    private void closeConnection() throws SQLException {
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
    }

    private Object[][] executeQuery(String query, List<Column> columns) throws SQLException {
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

    private int executeUpdate(String query) throws SQLException {
        int result;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            result = preparedStatement.executeUpdate();
        } finally {
            if (!query.startsWith("UPDATE Usuarios \nSET last_used"))
                closeConnection();
        }
        return result;
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

    public static String getNumDosis(String numeroDosis) throws SQLException {
        String numDosis;
        numDosis = switch (numeroDosis) {
            case "Primera dosis" -> "1";
            case "Segunda dosis" -> "2";
            case "Tercera dosis" -> "3";
            case "Refuerzo" -> "R";
            case "Primer refuerzo" -> "R1";
            case "Segundo refuerzo" -> "R2";
            case "Dosis previa" -> "P";
            default -> null;
        };
        if (numDosis == null) {
            throw new SQLException("Número de dosis no expected. TIMEOUT");
        }
        return numDosis;
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