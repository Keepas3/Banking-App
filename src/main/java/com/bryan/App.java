package com.bryan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Temporary entry point that checks both database connections.
 * Settings come from application.properties (see application.properties.example);
 * environment variables PG_URL, PG_USER, PG_PASSWORD, MONGO_URI and MONGO_DATABASE override the file.
 */
public class App {

    private static final Path CONFIG_FILE = Path.of("application.properties");

    public static void main(String[] args) throws Exception {
        Properties config = loadConfig();

        String pgUrl = setting(config, "PG_URL", "postgres.url");
        String pgUser = setting(config, "PG_USER", "postgres.username");
        String pgPassword = setting(config, "PG_PASSWORD", "postgres.password");
        String mongoUri = setting(config, "MONGO_URI", "mongo.uri");
        String mongoDatabase = setting(config, "MONGO_DATABASE", "mongo.database");

        try (Connection c = DriverManager.getConnection(pgUrl, pgUser, pgPassword)) {
            System.out.println("PostgreSQL connected: " + c.getMetaData().getDatabaseProductVersion());
        }

        try (MongoClient mongo = MongoClients.create(mongoUri)) {
            mongo.getDatabase(mongoDatabase).runCommand(new Document("ping", 1));
            System.out.println("MongoDB connected");
        }
    }

    /** Loads application.properties if present; a missing file is fine when env vars are set. */
    private static Properties loadConfig() throws IOException {
        Properties props = new Properties();
        if (Files.exists(CONFIG_FILE)) {
            try (var in = Files.newInputStream(CONFIG_FILE)) {
                props.load(in);
            }
        }
        return props;
    }

    /** Environment variable wins; otherwise the properties file value; otherwise a clear error. */
    private static String setting(Properties config, String envName, String propertyKey) {
        String value = System.getenv(envName);
        if (value == null || value.isBlank()) {
            value = config.getProperty(propertyKey);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing setting '" + propertyKey + "'. Add it to "
                    + CONFIG_FILE + " (copy application.properties.example) or set " + envName + ".");
        }
        return value.trim();
    }
}
