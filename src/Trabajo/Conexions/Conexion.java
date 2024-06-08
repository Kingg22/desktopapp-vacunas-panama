package Trabajo.Conexions;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Conexion {
    private static Dotenv dotenv = Dotenv.configure().load();
    private static String puerto = dotenv.get("PUERTO");
    private static String servidor = dotenv.get("SERVER");
    private static String passwordPac = dotenv.get("PASSWORD_PAC");
    private static String passwordDoc = dotenv.get("PASSWORD_DOC");
    private static String passwordProv = dotenv.get("PASSWORD_PROV");
    private static String password = dotenv.get("PASSWORD_ADM");
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