package com.techelevator.model;

import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private int clientId;
    private int packageId;
    private String status;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(int orderId, int clientId,int packageId, String status, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.packageId = packageId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
