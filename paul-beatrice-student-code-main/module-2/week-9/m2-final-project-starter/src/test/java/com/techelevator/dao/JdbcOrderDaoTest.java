package com.techelevator.dao;


import com.techelevator.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcOrderDaoTest {

    private JdbcOrderDao orderDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost:5432/m2_final_project_test",
                "postgres",
                "postgres1",
                true
        );

        jdbcTemplate = new JdbcTemplate(dataSource);
        orderDao = new JdbcOrderDao(jdbcTemplate);

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-data.sql"));
    }

    @Test
    void getAllOrders_returnsOrdersList() {
        List<Order> orders = orderDao.getAllOrders();
        assertFalse(orders.isEmpty());
    }

    @Test
    void getOrdersById_returnsCorrectOrder() {
        Order order = orderDao.getOrderById(1);
        assertNotNull(order);
        assertEquals("new", order.getStatus());
    }

    @Test
    void createOrder_addsAndReturnsNewOrder() {
        Order newOrder = new Order();
        newOrder.setClientId(1);
        newOrder.setPackageId(2);
        newOrder.setStatus("pending");

        Order createdOrder = orderDao.createOrder(newOrder);
        assertNotNull(createdOrder);
        assertEquals("pending", createdOrder.getStatus());
    }

    @Test
    void updateOrder_updatesCorrectOrder() {
        Order order = orderDao.getOrderById(1);
        assertNotNull(order);

        order.setStatus("completed");

        boolean isUpdated = orderDao.updateOrder(order);
        assertTrue(isUpdated);

        Order updatedOrder = orderDao.getOrderById(1);
        assertNotNull(updatedOrder);
        assertEquals("completed", updatedOrder.getStatus());
    }

    @Test
    void updateOrderStatus_updatesOrderCorrectly() {
        boolean isUpdated = orderDao.updateOrderStatus(1, "completed");
        assertTrue(isUpdated);

        Order updatedOrder = orderDao.getOrderById(1);
        assertEquals("completed", updatedOrder.getStatus());
    }

    @Test
    void deleteOrder_removesOrder() {
        boolean deleted = orderDao.deleteOrder(1);
        assertTrue(deleted);

        Order order = orderDao.getOrderById(1);
        assertNull(order);
    }
}
