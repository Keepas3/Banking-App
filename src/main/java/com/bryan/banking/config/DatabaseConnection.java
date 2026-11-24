package com.bryan.banking.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            Properties config = loadConfig();
            String url      = setting(config, "PG_URL",      "postgres.url");
            String user     = setting(config, "PG_USER",     "postgres.username");
            String password = setting(config, "PG_PASSWORD", "postgres.password");
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Warning: failed to close DB connection — " + e.getMessage());
        }
    }

    private static Properties loadConfig() {
        Properties props = new Properties();
        Path file = Path.of("application.properties");
        if (Files.exists(file)) {
            try (InputStream in = Files.newInputStream(file)) {
                props.load(in);
            } catch (IOException e) {
                System.err.println("Warning: could not read application.properties — " + e.getMessage());
            }
        }
        return props;
    }

    private static String setting(Properties config, String envName, String propKey) {
        String value = System.getenv(envName);
        if (value == null || value.isBlank()) {
            value = config.getProperty(propKey);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                "Missing config '" + propKey + "'. Add it to application.properties or set env var " + envName);
        }
        return value.trim();
    }
}
