package JDBC;

import java.sql.*;

public class JdbcCrudOperationsTestClass {
    static String url = "jdbc:mysql://localhost:3306/crudOperation";
    static String username = "root";
    //Give the password to access MySQL server
    static String password = "";

    public static void main(String[] args) throws SQLException {
//        selectRecords();
//        selectColumnFromRecords();
//        selectRecordsWithCondition();
//        selectRecordsWithExternalParameters(24);
//        selectRecordsWithPreparedStatement(18);
//        insertRecord();
//        insertRecordWithVariables(18, "SP", 780000);
//        insertRecordWithPreparedStatement(11, "MDH", 670000);
//        deleteRecord();
//        deleteRecordWithVariables(22);
//        deleteRecordWithPreparedStatement(15);
//        updateRecord();
//        updateRecordWithVariables(18, 850000);
//        updateRecordWithPreparedStatement(17, 880000);
    }

    public static void selectRecords() throws SQLException {
        String query = "select * from product";
        //Step 1 - connect database
        Connection connection = DriverManager.getConnection(url, username, password);
        //Step 2 - Creating statement
        Statement statement = connection.createStatement();
        //Step 3 - Executing query and Processing resultSet
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.print("\nId is: " + resultSet.getInt(1));
            System.out.print("\nName is: " + resultSet.getString(2));
            System.out.print("\nPrice is: " + resultSet.getDouble(3));
            System.out.print("\nQuantity is: " + resultSet.getInt(4));
        }
        //Step 4 - Close connection
        connection.close();
    }

    public static void selectColumnFromRecords() throws SQLException {
        String query = "select id, name, price from product";
        //Step 1 - connect database
        Connection connection = DriverManager.getConnection(url, username, password);
        //Step 2 - Creating statement
        Statement statement = connection.createStatement();
        //Step 3 - Executing query and Processing resultSet
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.print("\nId is: " + resultSet.getInt(1));
            System.out.print("\nName is: " + resultSet.getString(2));
            System.out.print("\nPrice is: " + resultSet.getDouble(3));
        }
        //Step 4 - Close connection
        connection.close();
    }

    public static void selectRecordsWithCondition() throws SQLException {
        String selectQuery = "select id, name, price from product where id = 31";
        //Step 1 - connect database
        Connection connection = DriverManager.getConnection(url, username, password);
        //Step 2 - Creating statement
        Statement statement = connection.createStatement();
        //Step 3 - Executing selectQuery and Processing resultSet
        ResultSet resultSet = statement.executeQuery(selectQuery);
        while (resultSet.next()) {
            System.out.print("\nId is: " + resultSet.getInt(1));
            System.out.print("\nName is: " + resultSet.getString(2));
            System.out.print("\nPrice is: " + resultSet.getDouble(3));
        }
        //Step 4 - Close connection
        connection.close();
    }

    public static void selectRecordsWithExternalParameters(int id) throws SQLException {
        // int emp_id = 24;
        // String selectQuery = "select emp_id, emp_name from employee " + "where emp_id = 24";
        String selectQuery = "select id, name, price from product " + "where id = " + id;
        //Step 1 - connect database
        Connection connection = DriverManager.getConnection(url, username, password);
        //Step 2 - Creating statement
        Statement statement = connection.createStatement();
        //Step 3 - Executing selectQuery and Processing resultSet
        ResultSet resultSet = statement.executeQuery(selectQuery);
        while (resultSet.next()) {
            System.out.print("\nId is: " + resultSet.getInt(1));
            System.out.print("\nName is: " + resultSet.getString(2));
            System.out.print("\nPrice is: " + resultSet.getDouble(3));
        }
        //Step 4 - Close connection
        connection.close();
    }

    public static void selectRecordsWithPreparedStatement(int id) throws SQLException {
        // int emp_id = 24;
        // String query = "select emp_id, emp_name from employee " + "where emp_id = 24";
        //  String query = "select emp_id, emp_name from employee where emp_id = ?";
        //Step 1 - connect database
        Connection connection = DriverManager.getConnection(url, username, password);
        //Step 2 - Creating statement
        PreparedStatement preparedStatement = connection.prepareStatement("select emp_id, emp_name from employee where emp_id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        //Step 3 - Executing query and Processing resultSet
        // ResultSet resultSet = preparedStatement.executeQuery(query);
        while (resultSet.next()) {
            System.out.print("\nId is: " + resultSet.getInt(1));
            System.out.print("\nName is: " + resultSet.getString(2));

        }
        //Step 4 - Close connection
        connection.close();
    }

    public static void insertRecord() throws SQLException {
        String insertQuery = "insert into employee values(34, 'MCC', 720000, 'AAA')";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        int row = statement.executeUpdate(insertQuery);
        System.out.println("Number of rows affected: " + row);
        connection.close();
    }

    public static void insertRecordWithVariables(int id, String name, int salary) throws SQLException {
        //String insertQuery = "insert into employee values(15, 'ABR', 720000)";
        String insertQuery = "insert into employee values(" + id + ", '" + name + "'," + salary + ")";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println("Number of rows affected: " + statement.executeUpdate(insertQuery));
        connection.close();
    }

    public static void insertRecordWithPreparedStatement(int id, String name, int salary) throws SQLException {
        //String insertQuery = "insert into employee values(15, 'ABR',720000);";
//        String insertQuery = "insert into employee values(" + id + ", '" + name + "'," + salary + ")";
        String insertQuery = "insert into employee values(?, ?, ?)";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, salary);
        System.out.println("Number of rows affected: " + preparedStatement.executeUpdate());
        connection.close();
    }

    public static void deleteRecord() throws SQLException {
        String deleteQuery = "delete from employee where emp_id = 11";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println("Number of rows affected: " + statement.executeUpdate(deleteQuery));
        connection.close();
    }

    public static void deleteRecordWithVariables(int id) throws SQLException {
        // String deleteQuery = "delete from employee where emp_id = 11";
        String deleteQuery = "delete from employee where emp_id = " + id;
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println("Number of rows affected: " + statement.executeUpdate(deleteQuery));
        connection.close();
    }

    public static void deleteRecordWithPreparedStatement(int id) throws SQLException {
        // String deleteQuery = "delete from employee where emp_id = 11";
        // String deleteQuery = "delete from employee where emp_id = " + id;
        String deleteQuery = "delete from employee where emp_id = ?";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id);
        System.out.println("Number of rows affected: " + preparedStatement.executeUpdate());
        connection.close();
    }

    public static void updateRecord() throws SQLException {
        String updateQuery = "update employee set salary = 800000 where emp_id = 17";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println("Number of rows affected: " + statement.executeUpdate(updateQuery));
        connection.close();
    }

    public static void updateRecordWithVariables(int id, int salary) throws SQLException {
        //String updateQuery = "update employee set salary = 800000 where emp_id = 15;";
        String updateQuery = "update employee set salary = " + salary + " where " + "emp_id = " + id;
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println("Number of rows affected: " + statement.executeUpdate(updateQuery));
        connection.close();
    }

    public static void updateRecordWithPreparedStatement(int id, int salary) throws SQLException {
        //String updateQuery = "update employee set salary = 800000 where emp_id = 15";
        //String updateQuery = "update employee set salary = " + salary + "where " + "emp_id = " + id;
        String updateQuery = "update employee set salary = ? where emp_id = ?";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setInt(1, salary);
        preparedStatement.setInt(2, id);
        System.out.println("Number of rows affected: " + preparedStatement.executeUpdate());
        connection.close();
    }
}
