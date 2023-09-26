package fr.mns.jee.erasmusnetwork.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/forum?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "seminaire3HNFIOP]#@$@$#sacew";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.");
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
