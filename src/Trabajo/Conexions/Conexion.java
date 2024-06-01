package Trabajo.Conexions;

import java.sql.*;

public class Conexion {
    private static String puerto = System.getenv("PUERTO");
    private static String servidor = System.getenv("SERVER");
    private static String passwordPac = System.getenv("PASSWORD_PAC");
    private static String passwordDoc = System.getenv("PASSWORD_DOC");
    private static String passwordProv = System.getenv("PASSWORD_PROV");
    private static final String URL = "jdbc:sqlserver://localhost\\" + servidor +":"+ puerto + ";database=MINSA;encrypt=false;integratedSecurity=true;";

    public static Connection getConnection(String usuario) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        usuario = usuario.toLowerCase().trim();
        return switch (usuario) {
            case "pac" -> DriverManager.getConnection(URL, "pacientes", passwordPac);
            case "doc" -> DriverManager.getConnection(URL, "doctores", passwordDoc);
            case "prov" -> DriverManager.getConnection(URL, "proveedores", passwordProv);
            case "admin" -> DriverManager.getConnection(URL);
            default -> null;
        };
    }
    public static void closeConnection(Connection connection) throws SQLException{
        if(connection != null) {
            connection.close();
        }
    }
}