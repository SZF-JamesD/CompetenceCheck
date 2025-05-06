package utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBHelpers {
    private final DBConnection dbConnection;

    public DBHelpers(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    @FunctionalInterface
    public interface SQLConsumer<T> {
        void accept(T t) throws SQLException;
    }

    @FunctionalInterface
    public interface SQLFunction<T, R> {
        R apply(T t) throws SQLException;
    }

    public static Connection getConnection(String db_name, DBConnection dbConnection) throws SQLException {
        return dbConnection.getConnection(db_name);
    }

    public void executeUpdate(String db_name, String sql, SQLConsumer<PreparedStatement> stmtSetter) throws SQLException {
        try (Connection con = getConnection(db_name, dbConnection);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmtSetter.accept(stmt);
            stmt.executeUpdate();
        }
    }

    public <T> List<T> executeQuery(String db_name, String sql, SQLConsumer<PreparedStatement> stmtSetter, SQLFunction<ResultSet, T> mapper) throws SQLException {
        List<T> results = new ArrayList<>();
        try (Connection con = getConnection(db_name, dbConnection);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmtSetter.accept(stmt);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    results.add(mapper.apply(rs));
                }
            }
        }
        return results;
    }

    public <T> T executeSingleResultQuery(String db_name, String sql, SQLConsumer<PreparedStatement> stmtSetter, SQLFunction<ResultSet, T> resultSetMapper) throws SQLException {
        try (Connection con = getConnection(db_name, dbConnection);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmtSetter.accept(stmt);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return resultSetMapper.apply(rs);
            } else {
                return null;
            }
        }
    }

    public void executeDelete(String db_name, String table, String condition, SQLConsumer<PreparedStatement> stmtSetter) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE " + condition;
        executeUpdate(db_name ,sql, stmtSetter);
    }

    public void close(String db_name) throws SQLException {
        Connection con = dbConnection.getConnection(db_name);
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public void insertJsonData(String dbName, Map<String, List<Map<String, Object>>> data) {
        try {
            for (Map.Entry<String, List<Map<String, Object>>> entry: data.entrySet()) {
                String table = entry.getKey();
                List<Map<String, Object>> rows = entry.getValue();

                for (Map<String, Object> row : rows) {
                    StringBuilder sql = new StringBuilder("insert into " + table + " (");
                    StringBuilder placeholders = new StringBuilder(" values (");
                    List<Object> values = new ArrayList<>();

                    for (String column : row.keySet()) {
                        sql.append(column).append(",");
                        placeholders.append("?,");
                        values.add(row.get(column));
                    }

                    sql.setLength(sql.length() -1);
                    placeholders.setLength(placeholders.length() -1);

                    sql.append(")").append(placeholders).append(")");

                    executeUpdate(dbName, sql.toString(), stmt -> {
                        for (int i = 0; i < values.size(); i++) {
                            stmt.setObject(i + 1, values.get(i));
                        }
                    });
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
