package Trabajo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicColumns {
    List<String[]> resultados = new ArrayList<>();

    void getTableDynamic(String Table) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ?")) {
            stmt.setString(1, Table);
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getString(i);
                }
                resultados.add(row);
            }
            resultSet.close();
        }

        // Imprimir los resultados
        for (String[] row : resultados) {
            for (String column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public List<String[]> getResultados() {
        return resultados;
    }

    public void setResultados(List<String[]> resultados) {
        this.resultados = resultados;
    }
}