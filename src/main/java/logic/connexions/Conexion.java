package logic.connexions;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final Dotenv dotenv = Dotenv.configure().load();
    private static final String passwordPac = dotenv.get("PASSWORD_PAC");
    private static final String passwordDoc = dotenv.get("PASSWORD_DOC");
    private static final String passwordProv = dotenv.get("PASSWORD_PROV");
    private static final String passwordOfic = dotenv.get("PASSWORD_ADMINISTRATIVO");
    private static final String passwordAdm = dotenv.get("PASSWORD_ADM");
    private static final String password = dotenv.get("PASSWORD");
    private static final String URL = dotenv.get("DB_URL");

    public static Connection getConnection(String rol) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        rol = rol.toLowerCase().trim();
        return switch (rol) {
            case "paciente" -> DriverManager.getConnection(URL, "Pacientes", passwordPac);
            case "doctor - enfermera" -> DriverManager.getConnection(URL, "Doctores", passwordDoc);
            case "proveedor" -> DriverManager.getConnection(URL, "Proveedores", passwordProv);
            case "administrativo" -> DriverManager.getConnection(URL, "Administrativos", passwordOfic);
            case "administrador", "autoridad" -> DriverManager.getConnection(URL, "Administradores", passwordAdm);
            case "app" -> DriverManager.getConnection(URL, "ApplicationJava", password);
            default -> null;
        };
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}