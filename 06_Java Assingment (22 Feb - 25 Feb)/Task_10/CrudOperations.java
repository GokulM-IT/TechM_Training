package Task_10;
import java.sql.*;

//Write a Java program to perform CRUD operations on a table using JDBC API.

public class CrudOperations {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_db_name";
        String username = "root";
        String password = "password";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String insertQuery = "INSERT INTO students (name, age) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "John");
                preparedStatement.setInt(2, 25);
                preparedStatement.executeUpdate();
            }
            String selectQuery = "SELECT * FROM students";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Age: " + resultSet.getInt("age"));
                }
            }
            String updateQuery = "UPDATE students SET age = ? WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, 26);
                preparedStatement.setString(2, "John");
                preparedStatement.executeUpdate();
            }
            String deleteQuery = "DELETE FROM students WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, "John");
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
