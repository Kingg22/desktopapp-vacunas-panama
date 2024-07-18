package logic.conexions;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import logic.scanner_database.Column;
import logic.scanner_database.DatabaseInfo;
import logic.validations.InicioSesion;

import java.sql.Date;
import java.sql.*;
import java.util.*;

public class DatabaseOperaciones {
    private Connection connection = null;
    private String usuarioActual = null;
    private DatabaseInfo databaseInfo = null;
    private boolean adminCreateBD = false;

    public int insertarDosis(String user, String password, String rol, String cedulaPaciente, Timestamp fechaAplicacion, String numero_dosis, int idVacuna, int idSede, String lote) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            throw new SQLException("NO estas registrado para ejecutar un comando. TIMEOUT");
        } else {
            if (!rol.equals("Fabricante") && !rol.equals("Paciente")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            try {
                SQLServerCallableStatement callstmt = (SQLServerCallableStatement) connection.prepareCall("{call dbo.InsertarDosis(?, ?, ?, ?, ?, ?)}");
                callstmt.setString(1, cedulaPaciente);
                callstmt.setDateTime(2, fechaAplicacion);
                callstmt.setString(3, getNumDosis(numero_dosis));
                callstmt.setInt(4, idVacuna);
                callstmt.setInt(5, idSede);
                callstmt.setString(6, lote);
                return countRowSQLUpdate(callstmt);
            } finally {
                closeConnection();
            }
        }
    }

    public Resultados showReporteVacunacionFiltrado(String user, String password, String rol, int idSede) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Paciente") && !rol.equals("Fabricante")) {
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
            int[] columnasWidth = new int[7];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement(
                        """
                                SELECT CedulaPaciente, NombrePaciente, ApellidoPaciente, FechaNacimiento, Sexo, NombreVacuna, NumeroDosis\s
                                FROM [Reporte Vacunas Completo]\s
                                WHERE CONVERT(date, FechaAplicacion) = CONVERT(date, GETDATE()) AND IDSede = ?""");
                callStmt.setInt(1, idSede);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados showLoteSedeVacuna(String user, String password, String rol, String lote) throws SQLException, ClassNotFoundException {
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
            String[] columnas = new String[6];
            int[] columnasWidth = new int[6];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement(
                        "SELECT [Nombre sede], [Depedencia sede], Vacuna, Cantidad, Lote, [Fecha Lote]  " +
                                "FROM [Sede - Inventario] \n" +
                                "WHERE Lote = ?");
                callStmt.setString(1, lote);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados showSedeInventarioVacuna(String user, String password, String rol, int idSede, int idVacuna) throws SQLException, ClassNotFoundException {
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
            String[] columnas = new String[8];
            int[] columnasWidth = new int[8];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement(
                        "SELECT *  FROM [Sede - Inventario] \n" +
                                "WHERE ID_Sede = ? AND [ID Vacuna] = ?");
                callStmt.setInt(1, idSede);
                callStmt.setInt(2, idVacuna);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
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
            int[] columnasWidth = new int[4];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement(
                        "SELECT Vacuna, Cantidad, Lote, [Fecha Lote]  FROM [Sede - Inventario] \n" +
                                "WHERE ID_Sede = ?");
                callStmt.setInt(1, idSede);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
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
            if (!rol.equals("Fabricante") && !rol.equals("Paciente")) {
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
                return countRowSQLUpdate(callstmt);
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
            int[] columnasWidth = new int[5];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement("SELECT * FROM dbo.BuscarUsuario(?, ?)");
                callStmt.setString(1, cedulaUsuario);
                callStmt.setInt(2, tipo);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
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
            int[] columnasWidth = new int[columns.size()];
            for (int i = 0; i < columns.size(); i++) {
                columnasWidth[i] = columns.get(i).getSize();
            }
            return new Resultados(new String[columns.size()], columnasWidth, executeQuery(("SELECT * FROM [Usuarios]"), columns));
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
            if (!rol.equals("Fabricante")) {
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

    public Resultados searchTablePaciente(String user, String password, String rol, String cedula, String nombreCompleto, String fechaNacimiento) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Fabricante")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForTable("Paciente");
            columns.removeLast();
            columns.add(new Column("direccion", "varchar", 255));
            columns.add(new Column("distrito", "varchar", 100));
            String[] columnas = new String[columns.size()];
            int[] columnasWidth = new int[columns.size()];
            for (int i = 0; i < columns.size(); i++) {
                columnas[i] = columns.get(i).getName();
                columnasWidth[i] = columns.get(i).getSize();
            }
            // Construcción de la consulta SQL dinámica
            StringBuilder sqlBuilder = new StringBuilder("SELECT cedula, nombre_paciente, apellido_paciente, fecha_nacimiento, edad_calculada, sexo, telefono_paciente, correo_electronico_paciente, direccion, distrito FROM Paciente LEFT JOIN Direccion d ON idDireccion = d.ID_direccion LEFT JOIN Distrito dd ON d.idDistrito = dd.ID_distrito WHERE 1=1");

            if (cedula != null && !cedula.trim().isEmpty()) {
                sqlBuilder.append(" AND cedula = '").append(cedula).append("'");
            }
            if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
                sqlBuilder.append(" AND CONCAT(nombre_paciente, ' ', apellido_paciente) LIKE '%").append(nombreCompleto).append("%'");
            }
            if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
                fechaNacimiento = String.valueOf(Date.valueOf(fechaNacimiento));
                sqlBuilder.append(" AND CAST(fecha_nacimiento AS DATE) = '").append(fechaNacimiento).append("'");
            }
            return new Resultados(columnas, columnasWidth, executeQuery(sqlBuilder.toString(), columns));
        }
    }

    public Resultados searchPaciente(String user, String password, String rol, String cedula, String nombreCompleto, String fechaNacimiento) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Fabricante")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForView("Vista Doctor");
            String[] columnas = new String[columns.size()];
            int[] columnasWidth = new int[columns.size()];
            for (int i = 0; i < columns.size(); i++) {
                columnas[i] = columns.get(i).getName();
                columnasWidth[i] = columns.get(i).getSize();
            }
            // Construcción de la consulta SQL dinámica
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM [Vista Doctor] WHERE 1=1");

            if (cedula != null && !cedula.trim().isEmpty()) {
                sqlBuilder.append(" AND Cédula = '").append(cedula).append("'");
            }
            if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
                sqlBuilder.append(" AND CONCAT(Nombre, ' ', Apellido) LIKE '%").append(nombreCompleto).append("%'");
            }
            if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
                fechaNacimiento = String.valueOf(Date.valueOf(fechaNacimiento));
                sqlBuilder.append(" AND CAST([Fecha de Nacimiento] AS DATE) = '").append(fechaNacimiento).append("'");
            }
            return new Resultados(columnas, columnasWidth, executeQuery(sqlBuilder.toString(), columns));
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
            int[] columnasWidth = new int[6];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement("SELECT [Nombre Vacuna], [Número de dosis], [Enfermedad previene], [Fecha de aplicación], Sede, Dependencia \nFROM [Vista Paciente] \nWHERE Cédula = ?");
                callStmt.setString(1, cedula);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
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
            String[] columnas = new String[20];
            int[] columnasWidth = new int[20];
            try {
                SQLServerPreparedStatement callStmt = (SQLServerPreparedStatement) connection.prepareStatement(
                        """
                                SELECT Cédula, Nombre, Apellido, [Fecha de Nacimiento], [Edad], Sexo, Teléfono, \
                                [Correo electrónico], [Dirección residencia actual], Distrito, Provincia, [Nombre vacuna], \
                                Fabricante, [Fecha de aplicación], Sede, Dependencia, [Número de dosis], \
                                [Intervalo dosis 1 y 2 recomendado en meses], [Intervalo real en días], [Edad mínima recomendada en meses]\s
                                FROM [Vista Doctor]\s
                                WHERE [ID Sede] = ?""");
                callStmt.setInt(1, idSede);
                processResult(callStmt, columns, columnas, columnasWidth, resultList);
            } finally {
                closeConnection();
            }
            return new Resultados(columnas, columnasWidth, resultList.toArray(new Object[0][]));
        }
    }

    public Resultados buscarDosis(String user, String password, String rol, String fechaInicio, String fechaFin, int idSede, int idVacuna, String numDosis) throws SQLException, ClassNotFoundException {
        if (!InicioSesion.autentificar(user, password, rol)) {
            return null;
        } else {
            if (!rol.equals("Fabricante")) {
                switchUser(rol, user);
                if (connection == null) {
                    throw new SQLException("Ocurrió un error al conectarse a la base de datos. Acceso denegado");
                }
            } else {
                throw new SQLException("NO tiene permiso para ejecutar este comando. TIMEOUT");
            }
            List<Column> columns = databaseInfo.getColumnsForView("Vista Doctor");
            String[] columnas = new String[columns.size()];
            int[] columnasWidth = new int[columns.size()];
            for (int i = 0; i < columns.size(); i++) {
                columnas[i] = columns.get(i).getName();
                columnasWidth[i] = columns.get(i).getSize();
            }

            StringBuilder query = new StringBuilder("SELECT * FROM [Vista Doctor] WHERE 1=1");

            if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
                fechaInicio = String.valueOf(Date.valueOf(fechaInicio));
                query.append(" AND CAST([Fecha de aplicación] AS DATE) >= '").append(fechaInicio).append("'");
            }
            if (fechaFin != null && !fechaFin.isEmpty()) {
                fechaFin = String.valueOf(Date.valueOf(fechaFin));
                query.append(" AND CAST([Fecha de aplicación] AS DATE) <= '").append(fechaFin).append("'");
            }
            if (idSede != -1) {
                query.append(" AND [ID Sede] = ").append(idSede);
            }
            if (idVacuna != -1) {
                query.append(" AND [ID Vacuna] = ").append(idVacuna);
            }
            if (numDosis != null && numDosis.length() <= 2 && !numDosis.isBlank()) {
                query.append(" AND [Número de dosis] = '").append(numDosis).append("'");
            }
            return new Resultados(columnas, columnasWidth, executeQuery(query.toString(), columns));
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
                int[] columnasWidth = new int[columnasLista.size()];
                for (int i = 0; i < columnasLista.size(); i++) {
                    column[i] = columnasLista.get(i).getName();
                    columnasWidth[i] = columnasLista.get(i).getSize();
                }
                resultados = new Resultados(column, columnasWidth, executeQuery(query, columnasLista));
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

    private int countRowSQLUpdate(SQLServerCallableStatement callableStatement) throws SQLException {
        int count = callableStatement.executeUpdate();
        count += callableStatement.getUpdateCount();
        while (!callableStatement.getMoreResults()) {
            if (callableStatement.getUpdateCount() == -1) {
                break;
            }
            count += callableStatement.getUpdateCount();
        }
        return count;
    }

    private void processResult(SQLServerPreparedStatement statement, List<Column> columns, String[] columnas, int[] columnasWidth, List<Object[]> resultList) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columns.add(new Column(metaData.getColumnName(i), metaData.getColumnTypeName(i), metaData.getColumnDisplaySize(i)));
        }
        for (int i = 0; i < columns.size(); i++) {
            columnasWidth[i] = columns.get(i).getSize();
            columnas[i] = columns.get(i).getName();
        }
        while (resultSet.next()) {
            Object[] row = new Object[columns.size()];
            for (int i = 0; i < columns.size(); i++) {
                row[i] = getColumnValueDynamic((SQLServerResultSet) resultSet, columns.get(i));
            }
            resultList.add(row);
        }
    }

    private boolean autentificadorTokenSesion(UUID token, String rol) {
        return true;
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