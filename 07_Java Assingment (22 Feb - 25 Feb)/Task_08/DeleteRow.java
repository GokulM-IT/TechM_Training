package Task_08;
import java.sql.*;
import java.util.Scanner;

/*
Write a Java program to delete the row from the table by using a delete query using Scanner class.
*/

public class DeleteRow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabase", "username", "password");

            System.out.print("Enter the ID of the row you want to delete: ");
            int id = sc.nextInt();

            String deleteQuery = "DELETE FROM your_table WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
