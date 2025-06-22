package com.example.alineservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {

    private static final String PROPERTIES_FILE = "/database.properties";
    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream input = DatabaseConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);

            String host = prop.getProperty("db.host");
            String port = prop.getProperty("db.port");
            String dbname = prop.getProperty("db.name");

            url = "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?useSSL=false&serverTimezone=UTC";
            username = prop.getProperty("db.username");
            password = prop.getProperty("db.password");

            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            System.err.println("Error al cargar las propiedades de conexión:");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
