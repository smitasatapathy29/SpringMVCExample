package com.cglia.si.DtabaseUtil;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseUtil {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/studentdetails");
        dataSource.setUsername("root");
        dataSource.setPassword("Smita@29");
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection established successfully!");
                // Do something with the connection
            } else {
                System.out.println("Failed to establish connection.");
            }
        } catch (SQLException e) {
            System.err.println("Error while establishing connection: " + e.getMessage());
        }
    }
}