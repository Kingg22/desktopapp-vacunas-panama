package Trabajo;
import java.sql.*;

public class DatabaseOperaciones {
    private Connection connection = null;
    private String usuarioActual = null;
    private String[][] resultados = new String[6][6];

    public DatabaseOperaciones() throws SQLException, ClassNotFoundException {
        // Por defecto, iniciar con el usuario "pac"
        cambiarUsuario("pac");
    }


    public void cambiarUsuario(String usuario) throws SQLException, ClassNotFoundException {
        // Cerrar la conexión actual si existe
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
        // Obtener una nueva conexión con el usuario especificado
        this.connection = Conexion.getConnection(usuario);
        this.usuarioActual = usuario;
    }

    public void queryViewPaciente() throws Exception {
        int i = -1;
        String query = "SELECT * FROM [Vista Paciente]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while(resultSet.next()) {// cambia de filas si existe
                i++;
                // reciben los datos de las columnas según su tipo de dato
                resultados[i][0] = resultSet.getString("cedula");
                resultados[i][1] = resultSet.getString("nombre_pac");
                resultados[i][2] = resultSet.getString("apellido_pac");
                resultados[i][3] = resultSet.getString("sexo");
                resultados[i][4] = resultSet.getString("fecha_aplicacion");
                resultados[i][5] = resultSet.getString("nombre_vac");
                // según las vista o tabla agregar
            }
        } catch (SQLException s) {
            throw s;
        }
    }

    public String[] getResultadosColumna(int numColum) {
        return resultados[numColum];
    }

    public String[][] getResultados() {
        return resultados;
    }

    public void closeConnection() throws SQLException {
        // Cerrar la conexión solo si está abierta
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
    }
    // getter y setter
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

    public void setResultados(String[][] resultados) {
        this.resultados = resultados;
    }
}
