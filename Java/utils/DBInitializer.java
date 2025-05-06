package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DBInitializer {
    private final DBConnection dbConnection;
    private final String dbName;

    public DBInitializer(DBConnection dbConnection, String dbName) {
        this.dbConnection = dbConnection;
        this.dbName = dbName;
    }

    public void initialize(Map<String, String> tableDefinitions) {
        createDatabase();
        createTables(tableDefinitions);
    }

    private void createDatabase() {
        try (Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement()) {

            stmt.executeUpdate("create database if not exists " + dbName);
            System.out.println("Database '" + dbName + "' created.");

        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
        }
    }

    private void createTables(Map<String, String> tableDefinitions) {
        try (Connection con = dbConnection.getConnection(dbName);
            Statement stmt = con.createStatement()) {

            for (Map.Entry<String, String> entry : tableDefinitions.entrySet()) {
                String tableName = entry.getKey();
                String tableDefinition = entry.getValue();

                String createTableSQL = "create table if not exists " + tableName + " (" + tableDefinition + ")";
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table '" + tableName + "' created.");
            }
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

}
