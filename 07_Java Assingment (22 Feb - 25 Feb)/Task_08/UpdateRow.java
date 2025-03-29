package Task_08;
import java.sql.*;
import java.util.Scanner;

/*
Write a Java program to update the row of a table dynamically using Scanner class.
*/

public class UpdateRow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabase", "username", "password");

            System.out.print("Enter the ID of the row you want to update: ");
            int id = in.nextInt();
            in.nextLine();

            System.out.print("Enter new value for column1: ");
            String newCol1 = in.nextLine();
            System.out.print("Enter new value for column2: ");
            String newCol2 = in.nextLine();

            String updateQuery = "UPDATE your_table SET column1 = ?, column2 = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, newCol1);
            preparedStatement.setString(2, newCol2);
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row updated successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
