package JDBC_Excepciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaUsoPropiedades {

	public static void main(String[] args) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Obtenemos la conexión
            connection = UConnection.getConnection();
            System.out.println("Conexión establecida.");

            // Ejemplo de consulta
            String sql = "SELECT * FROM ejemplo";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            // Procesamos el resultado
            while (resultSet.next()) {
                // Suponiendo que mi_tabla tiene una columna llamada "nombre"
                String nombre = resultSet.getString("ID");
                System.out.println("ID: " + nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerramos los recursos en el orden inverso de apertura
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

	}

}
