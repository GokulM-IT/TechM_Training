package JDBC.employeeAssignment;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCrudManagement {
    static String url = "jdbc:mysql://localhost:3306/employeeManagement";
    static String username = "root";
    static String password = "";

    static Connection connection = null;
    static Statement statement = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    // Statement
    public static void displayEmployee() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        String selectQuery = "SELECT * FROM employee";
        resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            System.out.print("\nId is: " + resultSet.getInt(1));
            System.out.print("\nName is: " + resultSet.getString(2));
            System.out.print("\nSalary is: " + resultSet.getDouble(3));
            System.out.print("\nPosition is: " + resultSet.getString(4));
            System.out.println();
        }

        connection.close();
    }

    public static void insertNewEmployee(String name, double salary, String position) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        String insertQuery = "INSERT INTO employee(emp_name, emp_salary, position) " + "Values('" + name + "', " + salary + ", '" + position + "')";
        int rowInsertCount = statement.executeUpdate(insertQuery);
        System.out.println("Number of Rows affected: " + rowInsertCount);
        connection.close();
    }

    // PreparedStatement
    public static void updateEmployee(int emp_id, String name, double salary, String position) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        String updateQuery = "UPDATE employee set emp_name = ?, emp_salary = ?, position = ? where emp_id = ?";
        preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, salary);
        preparedStatement.setString(3, position);
        preparedStatement.setInt(4, emp_id);
        int rowInsertCount = preparedStatement.executeUpdate();
        System.out.println("Number of Rows affected: " + rowInsertCount);
        connection.close();
    }

    public static void deleteEmployee(int emp_id) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        String deleteQuery = "DELETE from employee where emp_id = ?";
        preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, emp_id);
        int rowInsertCount = preparedStatement.executeUpdate();
        System.out.println("Number of Rows affected: " + rowInsertCount);
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        boolean isRun = true;
        do {
            System.out.println();
            System.out.println("Select which operation you want to perform? \n1.Display\n2.Insert\n3.Update\n4.Delete\n5.Exit\n(eg. If 'Display' Enter 1)");
            int operation = in.nextInt();
            switch (operation) {
                case 1 -> displayEmployee();
                case 2 -> {
                    System.out.println("Enter the details: ");
                    System.out.print("Name: ");
                    String name = in.next();
                    System.out.print("Salary: ");
                    double salary = in.nextDouble();
                    in.nextLine();
                    System.out.print("Position: ");
                    String position = in.nextLine();
                    insertNewEmployee(name, salary, position);
                    System.out.println("Successfully Inserted.");
                }
                case 3 -> {
                    System.out.print("Enter the employee ID and Details to be updated: ");
                    System.out.print("\nEnter employee ID: ");
                    int emp_id = in.nextInt();
                    System.out.print("Enter employee name: ");
                    String emp_name = in.next();
                    System.out.print("Enter employee salary: ");
                    double emp_salary = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter employee position: ");
                    String emp_position = in.next();
                    updateEmployee(emp_id, emp_name, emp_salary, emp_position);
                    System.out.println("Successfully Updated.");
                }
                case 4 -> {
                    System.out.print("Enter employee ID to delete: ");
                    int emp_id = in.nextInt();
                    deleteEmployee(emp_id);
                    System.out.println("Successfully Deleted.");
                }
                case 5 -> isRun = false;
            }
        } while (isRun);
    }

//        boolean isRun = true;
//        do {
//            System.out.println();
//            System.out.println("Select which operation you want to perform? \n1.Display\n2.Insert\n3.Update\n4.Delete\n5.Exit\n(eg. If 'Display' Enter 1)");
//            String operation = in.next();
//            switch (operation.toLowerCase()) {
//                case "display" -> displayEmployee();
//                case "insert" -> {
//                    System.out.println("Enter the details: ");
//                    System.out.print("Name: ");
//                    String name = in.next();
//                    System.out.print("Salary: ");
//                    double salary = in.nextDouble();
//                    in.nextLine();
//                    System.out.print("Position: ");
//                    String position = in.nextLine();
//                    insertNewEmployee(name, salary, position);
//                    System.out.println("Successfully Inserted.");
//                }
//                case "update" -> {
//                    System.out.print("Enter the employee ID and Details to be updated: ");
//                    System.out.print("\nEnter employee ID: ");
//                    int emp_id = in.nextInt();
//                    System.out.print("Enter employee name: ");
//                    String emp_name = in.next();
//                    System.out.print("Enter employee salary: ");
//                    double emp_salary = in.nextDouble();
//                    in.nextLine();
//                    System.out.print("Enter employee position: ");
//                    String emp_position = in.next();
//                    updateEmployee(emp_id, emp_name, emp_salary, emp_position);
//                    System.out.println("Successfully Updated.");
//                }
//                case "delete" -> {
//                    System.out.print("Enter employee ID to delete: ");
//                    int emp_id = in.nextInt();
//                    deleteEmployee(emp_id);
//                    System.out.println("Successfully Deleted.");
//                }
//                case "exit" -> isRun = false;
//            }
//        } while (isRun);
//    }
}
