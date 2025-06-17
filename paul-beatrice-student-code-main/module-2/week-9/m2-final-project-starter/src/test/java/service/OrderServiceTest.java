package service;

import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import com.techelevator.dao.JdbcClientDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.model.Order;
import com.techelevator.service.OrderService;

public class OrderServiceTest {
    private OrderService orderService;
    private JdbcOrderDao orderDao;
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
        orderService = new OrderService(orderDao);

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-data.sql"));
    }

    @Test
    void createOrder_savesNewOrder() {
        Order newOrder = new Order();
        newOrder.setClientId(1);
        newOrder.setPackageId(2);
        newOrder.setStatus("pending");

        Order savedOrder = orderService.createOrder(newOrder);

        assertNotNull(savedOrder);
        assertEquals(1, savedOrder.getClientId());
        assertEquals(2, savedOrder.getPackageId());
        assertEquals("pending", savedOrder.getStatus());
    }

    @Test
    void getAllOrders_returnsCorrectListSize() {
        List<Order> orders = orderService.getAllOrders();
        assertFalse(orders.isEmpty());
        assertEquals(2, orders.size());
    }

    @Test
    void getOrdersById_returnsCorrectOrder() {
        Order order = orderService.getOrderById(1);
        assertNotNull(order);
        assertEquals(1, order.getOrderId());
        assertEquals("new", order.getStatus());
    }

    @Test
    void updateOrderStatus_updatesOrderCorrectly() {
        boolean updated = orderService.updateOrderStatus(1, "completed");
        assertTrue(updated);

        Order updatedOrder = orderService.getOrderById(1);
        assertEquals("completed", updatedOrder.getStatus());
    }

    @Test
    void deleteOrder_removesOrder() {
        boolean deleted = orderService.deleteOrder(1);
        assertTrue(deleted);

        Order order = orderService.getOrderById(1);
        assertNull(order);
    }
}
