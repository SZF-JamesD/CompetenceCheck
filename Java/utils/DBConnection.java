package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnection {
    private final Properties properties;

    public DBConnection(String configPath) throws IOException {
        this.properties = new Properties();
        FileInputStream configFile = new FileInputStream(configPath);
        properties.load(configFile);
    }

    public Connection getConnection() throws SQLException {
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection(String database) throws SQLException {
        String url = properties.getProperty("db.url") + database;
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }
}
