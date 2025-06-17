package dao;

import model.Order;
import config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOrdersDao implements OrdersDao {

    @Override
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders";

        try (Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getInt("client_id"),
                        resultSet.getInt("package_id"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        String sql = "SELECT * FROM Orders WHERE order_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getInt("client_id"),
                        resultSet.getInt("package_id"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void createOrder(Order order) {
        String sqlInsert = "INSERT INTO Orders (client_id, status, created_at) VALUES (?, ?, ?, ?)";
        String sqlSelectId = "SELECT order_id FROM Orders WHERE client_id = ? AND package_id = ? AND status = ? AND created_at = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
        PreparedStatement selectStatement = connection.prepareStatement(sqlSelectId)) {

            insertStatement.setInt(1, order.getClientId());
            insertStatement.setInt(2, order.getPackageId());
            insertStatement.setString(3, order.getStatus());
            insertStatement.setTimestamp(4, order.getCreatedAt());
            insertStatement.executeUpdate();

            selectStatement.setInt(1, order.getClientId());
            selectStatement.setInt(2, order.getPackageId());
            selectStatement.setString(3, order.getStatus());
            selectStatement.setTimestamp(4, order.getCreatedAt());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                order.setOrderId(resultSet.getInt("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {
        String sql = "UPDATE Orders SET client_id = ?, package_id = ?, status = ?, created_at = ? WHERE order_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, order.getClientId());
            preparedStatement.setInt(2, order.getPackageId());
            preparedStatement.setString(3, order.getStatus());
            preparedStatement.setTimestamp(4, order.getCreatedAt());
            preparedStatement.setInt(5, order.getOrderId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        String sql = "DELETE FROM Orders WHERE order_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
