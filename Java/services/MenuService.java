package services;

import models.WorkOrder;
import utils.DBHelpers;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private final DBHelpers dbHelpers;

    public MenuService(DBHelpers dbHelpers) {
        this.dbHelpers = dbHelpers;
    }

    public WorkOrder getWorkOrder(int id) {
        try {
            String sql = "select * from work_orders where id=?";
            return dbHelpers.executeSingleResultQuery("work_orders_db", sql, stmt ->
                        stmt.setInt(1, id),
                    rs ->
                         new WorkOrder(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("status"),
                                rs.getDate("date_created"),
                                rs.getInt("priority")
                        )



            );
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public List<WorkOrder> getAllOrders() {
        List<WorkOrder> orders = new ArrayList<>();
        try {
            String sql = "select * from work_orders order by id asc";
            dbHelpers.executeQuery("work_orders_db", sql,
                    stmt -> {
                    },
                    rs -> {
                        WorkOrder workOrder = new WorkOrder(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("status"),
                                rs.getDate("date_created"),
                                rs.getInt("priority")
                        );
                        orders.add(workOrder);
                        return orders;
                    }
            );
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return orders;
    }

    public void createOrder(String title, String description, String status, int prio) {
        try {
            String sql = "insert into work_orders (title, description, status, date_created, priority) values (?, ?, ?, ?, ?)";
            dbHelpers.executeUpdate("work_orders_db", sql, stmt -> {
                    stmt.setString(1, title);
                    stmt.setString(2, description);
                    stmt.setString(3, status);
                    stmt.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                    stmt.setInt(5, prio);
            });
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void changeStatus(int id, String status) {
        try {
            String sql = "update work_orders set status=? where id=?";
            dbHelpers.executeUpdate("work_orders_db", sql, stmt -> {
                stmt.setString(1, status);
                stmt.setInt(2, id);
            });
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public List<WorkOrder> getFiltered(String status) {
        List<WorkOrder> orders = new ArrayList<>();
        try {
            String sql = "select * from work_orders where status=?";
            dbHelpers.executeQuery("work_orders_db", sql, stmt ->
                stmt.setString(1, status)
            , rs -> {
                WorkOrder workOrder = new WorkOrder(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getDate("date_created"),
                        rs.getInt("priority")
                );
                orders.add(workOrder);
                return orders;
            });
        } catch (SQLException e) {
            System.out.println("Error: " +e);
        }
        return orders;
    }
}
