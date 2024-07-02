package Logica.Conexions;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Conexion {
    private static Dotenv dotenv = Dotenv.configure().load();
    private static String puerto = dotenv.get("PUERTO_P");
    private static String servidor = dotenv.get("SERVER");
    private static String passwordPac = dotenv.get("PASSWORD_PAC");
    private static String passwordDoc = dotenv.get("PASSWORD_DOC");
    private static String passwordProv = dotenv.get("PASSWORD_PROV");
    private static String passwordOfic = dotenv.get("PASSWORD_ADMINISTRATIVO");
    private static String password = dotenv.get("PASSWORD_ADM");
    private static final String URL = "jdbc:sqlserver://localhost\\" + servidor +":"+ puerto + ";database=MINSA;encrypt=false;";

    public static Connection getConnection(String rol) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        rol = rol.toLowerCase().trim();
        return switch (rol) {
            case "pac" -> DriverManager.getConnection(URL, "Pacientes", passwordPac);
            case "doc" -> DriverManager.getConnection(URL, "Doctores", passwordDoc);
            case "prov" -> DriverManager.getConnection(URL, "Proveedores", passwordProv);
            case "ofic" -> DriverManager.getConnection(URL, "Administrativos", passwordOfic);
            case "admin" -> DriverManager.getConnection(URL, "Administradores", password);
            default -> null;
        };
    }

    public static void closeConnection(Connection connection) throws SQLException{
        if(connection != null) {
            connection.close();
        }
    }
}