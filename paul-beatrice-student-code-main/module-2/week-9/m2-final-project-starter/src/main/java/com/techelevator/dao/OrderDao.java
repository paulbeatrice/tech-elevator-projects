package com.techelevator.dao;

import com.techelevator.model.Order;
import java.util.List;

public interface OrderDao {
 List<Order> getAllOrders();
 Order getOrderById(int orderId);
 List<Order> getOrdersByClientId(int clientId);
 Order createOrder(Order order);

 boolean updateOrder(Order order);
 boolean updateOrderStatus(int orderId, String status);
 boolean deleteOrder(int orderId);
}
