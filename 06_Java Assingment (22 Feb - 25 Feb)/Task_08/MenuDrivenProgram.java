package Task_08;
import java.sql.*;
import java.util.Scanner;

/*
Write a Java program that performs the following operations using a menu-driven program:
1. Insert a new Row
2. Update a Row
3. Delete a Row
4. Select the row
5. Exit
Use PreparedStatement class for all the above tasks.
*/

public class MenuDrivenProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabase", "username", "password");

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select the row");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1:
                        insertRow(connection, in);
                        break;
                    case 2:
                        updateRow(connection, in);
                        break;
                    case 3:
                        deleteRow(connection, in);
                        break;
                    case 4:
                        selectRow(connection, in);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRow(Connection connection, Scanner in) {
        try {
            String insertQuery = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            System.out.print("Enter value for column1: ");
            String col1 = in.nextLine();
            System.out.print("Enter value for column2: ");
            String col2 = in.nextLine();

            preparedStatement.setString(1, col1);
            preparedStatement.setString(2, col2);
            preparedStatement.executeUpdate();

            System.out.println("Row inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRow(Connection connection, Scanner in) {
        try {
            System.out.print("Enter the ID of the row you want to update: ");
            int id = in.nextInt();
            in.nextLine();

            System.out.print("Enter new value for column1: ");
            String newCol1 = in.nextLine();
            System.out.print("Enter new value for column2: ");
            String newCol2 = in.nextLine();

            String updateQuery = "UPDATE your_table SET column1 = ?, column2 = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
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

    public static void deleteRow(Connection connection, Scanner in) {
        try {
            System.out.print("Enter the ID of the row you want to delete: ");
            int id = in.nextInt();

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

    public static void selectRow(Connection connection, Scanner in) {
        try {
            System.out.print("Enter the ID of the row you want to select: ");
            int id = in.nextInt();

            String selectQuery = "SELECT * FROM your_table WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Row selected:");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Column1: " + resultSet.getString("column1"));
                System.out.println("Column2: " + resultSet.getString("column2"));
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
