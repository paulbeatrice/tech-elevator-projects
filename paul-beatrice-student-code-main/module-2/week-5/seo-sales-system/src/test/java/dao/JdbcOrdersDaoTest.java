package dao;

import model.Order;
import org.junit.jupiter.api.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class JdbcOrdersDaoTest {

    private JdbcOrdersDao ordersDao;

    @BeforeEach
    void setUp() {
        ordersDao = new JdbcOrdersDao();
    }

    @Test
    void testCreateOrder() {
        Timestamp createdAt = Timestamp.valueOf("2025-24-2025 11:30:00");
        Order order = new Order(0, 1, 1, "new", createdAt);

        ordersDao.createOrder(order);

        List<Order> orders = ordersDao.getOrders();
        boolean orderExists = false;
        for (Order o : orders) {
            if (o.getClientId() == 1 && o.getPackageId() == 1 && o.getStatus().equals("new")) {
                orderExists = true;
                break;
            }
        }
        assertTrue(orderExists, "The order should exist in database.");
    }

    @Test
    void testGetOrdersById() {
        Timestamp createdAt = Timestamp.valueOf("2025-24-2025 11:30:00");
        Order order = new Order(0, 1, 1, "new", createdAt);

        ordersDao.createOrder(order);
        Order retrieveOrder = ordersDao.getOrderById(order.getOrderId());

        assertNotNull(retrieveOrder, "The order should not be null.");
        assertEquals(order.getClientId(), retrieveOrder.getClientId(), "The client should match.");
        assertEquals(order.getPackageId(), retrieveOrder.getPackageId(), "The packageId should match.");
        assertEquals(order.getStatus(), retrieveOrder.getStatus(), "The order status should match.");

    }
    @Test
    void testUpdateOrder() {
        Timestamp createdAt = Timestamp.valueOf("2025-24-2025 11:30:00");
        Order order = new Order(0, 1, 1, "new", createdAt);

        ordersDao.createOrder(order);

        order.setStatus("pending");
        ordersDao.updateOrder(order);

        Order updatedOrder = ordersDao.getOrderById(order.getOrderId());
        assertEquals("pending", updatedOrder.getStatus(), "The order status should be updated.");

    }

    @Test
    void testDeletedOrder() {
        Timestamp createdAt = Timestamp.valueOf("2025-24-2025 11:30:00");
        Order order = new Order(0, 1, 1, "new", createdAt);

        ordersDao.createOrder(order);

        List<Order> orders = ordersDao.getOrders();
        Order createdOrder = null;
        for (Order o : orders) {
            if (o.getClientId() == 1 && o.getPackageId() == 1 && o.getStatus().equals("new")) {
                createdOrder = o;
                break;
            }
        }

        assertNotNull(createdOrder, "The order we are trying to delete should exist.");

        ordersDao.deleteOrder(createdOrder.getOrderId());
        Order deleteOrder = ordersDao.getOrderById(createdOrder.getOrderId());
        assertNull(deleteOrder, "The order should no longer exist after being deleted.");
    }
}
