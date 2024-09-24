package io.github.digsen02.db;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static String URL;
    private static String USER;
    private static  String PASSWORD;

    private DatabaseConnection() {
        Dotenv dotenv = Dotenv.load();
        URL = dotenv.get("JDBC_DATABASE_URL");
        USER = dotenv.get("JDBC_DATABASE_USERNAME");
        PASSWORD = dotenv.get("JDBC_DATABASE_PASSWORD");
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}