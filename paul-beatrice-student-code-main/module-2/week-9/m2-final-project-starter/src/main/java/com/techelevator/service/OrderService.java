package com.techelevator.service;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.model.Order;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final JdbcOrderDao orderDao;

    public OrderService(JdbcOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public Order createOrder(Order order) {
        if (order.getClientId() <= 0 || order.getPackageId() <+ 0) {
            throw new IllegalArgumentException("Client Id and Package Id must be valid.");
        }
        return orderDao.createOrder(order);
    }

    public boolean updateOrder(Order order) {
        if (order.getOrderId() <= 0) {
            throw new IllegalArgumentException("Invalid order Id.");
        }
        return orderDao.updateOrder(order);
    }

    public boolean updateOrderStatus(int orderId, String status) {
        if (orderId <= 0 || status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Order ID and status must be valid.");
        }
        return orderDao.updateOrderStatus(orderId, status);
    }

    public boolean deleteOrder(int orderId) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Invalid order Id.");
        }
        return orderDao.deleteOrder(orderId);
    }
}
