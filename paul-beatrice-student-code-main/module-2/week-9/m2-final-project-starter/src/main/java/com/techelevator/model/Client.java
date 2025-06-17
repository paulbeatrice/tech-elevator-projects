package com.techelevator.model;

import java.time.LocalDateTime;

public class Client {

    private int clientId;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public Client() {
    }

    public Client(int clientId, String name, String email, String phone, LocalDateTime createdAt) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }




    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" +clientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
