package com.example.alineservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {
    private static final String PROPERTIES_FILE = "/database.properties";

    public static Connection getConnection() throws SQLException {
        try (InputStream input = DatabaseConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.password");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new SQLException("Error cargando configuración de la base de datos", e);
        }
    }
}
