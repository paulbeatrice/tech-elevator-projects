package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDao  implements OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String getAllOrdersQuery = "SELECT * FROM orders ORDER BY created_at DESC";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(getAllOrdersQuery);
            while (results.next()) {
                orders.add(mapRowToOrder(results));
            }
        } catch (Exception e) {
            throw new DaoException("Error when retrieving orders", e);
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        String getOrderByIdQuery = "SELECT * FROM orders WHERE order_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(getOrderByIdQuery, orderId);
            if (results.next()) {
                order = mapRowToOrder(results);
            }
        } catch (Exception e) {
            throw new DaoException("Error when retrieving orders with ID: " + orderId, e);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByClientId(int clientId) {
        List<Order> orders = new ArrayList<>();
        String getOrdersByClientIdQuery = "SELECT * FROM orders WHERE client_id = ? ORDER BY created_at DESC";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(getOrdersByClientIdQuery, clientId);
            while (results.next()) {
                orders.add(mapRowToOrder(results));
            }
        } catch (Exception e) {
            throw new DaoException("Error when retrieving orders for client ID: " + clientId, e);
        }
        return orders;
    }

    @Override
    public Order createOrder(Order order) {
        String createOrderQuery = "INSERT INTO orders (client_id, package_id, status) VALUES (?, ?, ?) RETURNING order_id";

        try {
            int newOrderId = jdbcTemplate.queryForObject(createOrderQuery, Integer.class, order.getClientId(), order.getPackageId(), order.getStatus());
            return getOrderById(newOrderId);
        } catch (Exception e) {
            throw new DaoException("Error when creating order", e);
        }
    }

    @Override
    public boolean updateOrder(Order order) {
        String sql = "UPDATE orders SET client_id = ?, package_id = ?, status = ?, created_at = created_at WHERE order_id = ?";

        try {
            int rowsUpdated = jdbcTemplate.update(sql,
                    order.getClientId(),
                    order.getPackageId(),
                    order.getStatus(),
                    order.getOrderId());

            return rowsUpdated >0;
        } catch (Exception e) {
            throw new DaoException("Error when trying to update order with ID: " + order.getOrderId(), e);
        }
    }

    @Override
    public boolean updateOrderStatus(int orderId, String status) {
        String updateOrderStatusQuery = "UPDATE orders SET status = ? WHERE order_id = ?";

        try {
            int rowsUpdated = jdbcTemplate.update(updateOrderStatusQuery, status, orderId);
            return  rowsUpdated > 0;
        } catch (Exception e) {
            throw new DaoException("Error when trying to update order status for ID: " + orderId, e);
        }
    }

    @Override
    public boolean deleteOrder(int orderId) {
       String deleteOrderQuery = "DELETE FROM orders WHERE order_id = ?";

       try {
           int rowsDeleted = jdbcTemplate.update(deleteOrderQuery, orderId);
           return rowsDeleted > 0;
       } catch (Exception e) {
           throw new DaoException("Error when deleting order with ID: " + orderId, e);
       }
    }



    private Order mapRowToOrder(SqlRowSet rs) {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setClientId(rs.getInt("client_id"));
        order.setPackageId(rs.getInt("package_id"));
        order.setStatus(rs.getString("status"));

        Timestamp timestamp = rs.getTimestamp("created_at");
        if (timestamp != null) {
            order.setCreatedAt(timestamp.toLocalDateTime());
        }
        return order;
    }
}
