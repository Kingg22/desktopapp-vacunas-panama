package Trabajo.Conexions;

import java.sql.*;

public class Conexion {
    private static String puerto = System.getenv("PUERTO");
    private static String servidor = System.getenv("SERVER");
    private static String passwordPac = System.getenv("PASSWORD_PAC");
    private static String passwordDoc = System.getenv("PASSWORD_DOC");
    private static String passwordProv = System.getenv("PASSWORD_PROV");
    private static String password = System.getenv("PASSWORD_ADM");
    private static final String URL = "jdbc:sqlserver://localhost\\" + servidor +":"+ puerto + ";database=MINSA;encrypt=false;integratedSecurity=true;";

    public static Connection getConnection(String rol) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        rol = rol.toLowerCase().trim();
        return switch (rol) {
            // IMPLEMENTAR ROLES DE LA DATABASE Y NO LA CONEXIÓN
            case "pac" -> DriverManager.getConnection(URL, "pacientes", passwordPac);
            case "doc" -> DriverManager.getConnection(URL, "doctores", passwordDoc);
            case "prov" -> DriverManager.getConnection(URL, "proveedores", passwordProv);
            case "admin" -> DriverManager.getConnection(URL, "admin", password);
            default -> null;
        };
    }

    public static Connection setRoleConnection() throws SQLException, ClassNotFoundException {
        return null; // POR IMPLEMENTAR ROLES DE LA DATABASE
    }

    public static void closeConnection(Connection connection) throws SQLException{
        if(connection != null) {
            connection.close();
        }
    }
}