package com.lendingcatalog;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String contactInfo;
    private List<Vehicle> vehicles;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }


    @Override
    public String toString() {
        return "Customer Name: " + name + ", Contact Info: " + contactInfo;
    }
}
