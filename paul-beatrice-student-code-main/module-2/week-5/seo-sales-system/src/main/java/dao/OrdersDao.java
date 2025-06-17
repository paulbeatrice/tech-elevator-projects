package dao;

import model.Order;
import java.util.List;

public interface OrdersDao {
    List<Order> getOrders();
    Order getOrderById(int orderId);
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
}
