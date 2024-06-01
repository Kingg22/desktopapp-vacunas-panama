package Trabajo.Conexions;

import java.sql.*;
import java.util.*;

public class DatabaseOperaciones {
    private Connection connection = null;
    private String usuarioActual = null;
    private List<String[]> resultados = new ArrayList<>();
    private List<String> columnas = new ArrayList<>();

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

    public void queryViewPaciente() throws SQLException {
        queryView("SELECT * FROM [Vista Paciente]",
                Arrays.asList("cedula", "nombre_pac", "apellido_pac", "sexo", "edad_calculada", "fecha_aplicacion", "nombre_vac"));
    }

    public void queryViewDoctor() throws SQLException, ClassNotFoundException {
        cambiarUsuario("doc");
        queryView("SELECT * FROM [Vista Doctor]",
                Arrays.asList("id_doctor", "nombre_doc", "apellido_doc", "especialidad", "sexo", "fecha_ingreso", "nombre_hospital"));
    }

    public void queryViewProveedor() throws SQLException, ClassNotFoundException {
        cambiarUsuario("prov");
        queryView("SELECT * FROM [Vista Proveedor]",
                Arrays.asList("id_proveedor", "nombre_prov", "contacto_prov", "direccion_prov", "ciudad", "pais", "telefono"));
    }

    public void queryViewAdmin() throws SQLException, ClassNotFoundException {
        cambiarUsuario("admin");
        queryView("SELECT * FROM [Vista Admin]",
                Arrays.asList("id_admin", "nombre_admin", "apellido_admin", "cargo", "sexo", "fecha_inicio", "nombre_departamento"));
    }

    private void queryView(String query, List<String> columnasLista) throws SQLException {
        resultados.clear();
        columnas.clear();
        columnas.addAll(columnasLista);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String[] resultado = new String[columnasLista.size()];
                for (int i = 0; i < columnasLista.size(); i++) {
                    resultado[i] = resultSet.getString(columnasLista.get(i));
                }
                resultados.add(resultado);
            }
        }
    }

    public List<String[]> getResultados() {
        return resultados;
    }

    public String[][] getResultadosArray() {
        String[][] array = new String[resultados.size()][];
        for (int i = 0; i < resultados.size(); i++) {
            array[i] = resultados.get(i);
        }
        return array;
    }

    public List<String> getColumnas() {
        return columnas;
    }

    public String[] getColumnasArray() {
        return columnas.toArray(new String[0]);
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            Conexion.closeConnection(connection);
        }
    }

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
}