package Task_08;
import java.sql.*;
import java.util.Scanner;

/*
Write a Java program to recursively insert multiple row/s into the table.
Hint :: Use PreparedStatement
*/

public class InsertRowsRecursively {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabase", "username", "password");
            String insertQuery = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            System.out.print("Enter number of rows to insert: ");
            int numRows = in.nextInt();
            in.nextLine();

            insertRows(connection, preparedStatement, numRows, in);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRows(Connection connection, PreparedStatement preparedStatement, int numRows, Scanner sc) throws SQLException {
        if (numRows <= 0) return;

        System.out.print("Enter value for column1: ");
        String col1 = sc.nextLine();
        System.out.print("Enter value for column2: ");
        String col2 = sc.nextLine();

        preparedStatement.setString(1, col1);
        preparedStatement.setString(2, col2);
        preparedStatement.executeUpdate();

        System.out.println("Row inserted successfully.");

        insertRows(connection, preparedStatement, numRows - 1, sc);
    }
}
