package model;

import java.sql.*;

public class DataBaseConnector {
    private final String url = "jdbc:mysql://localhost:3306/database2?useUnicode=true&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    private static Connection connection = null;
    private static Statement statement = null;

        public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception " + e);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println("Problems with connection" + e);
        }
    }
}
