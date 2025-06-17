package com.lendingcatalog;

public class Vehicle {
    private String licensePlate;
    private String ownerName;
    private String make;
    private String model;
    private int year;
    private String color;

    public Vehicle(String licensePlate, String ownerName, String make, String model, int year, String color) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Getters

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    // Setters (if required to modify attributes)

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Additional Methods to display vehicle information

    public String getDetails() {
        return String.format("Owner: %s, License Plate: %s, Make: %s, Model %s, Year: %s, Year: %d, Color: %s",
                ownerName, licensePlate, make, model, year, color);
    }

    // Simplification of displaying Vehicle Details
    @Override
    public String toString() {
        return String.format("Owner: %s, License Plate: %s, Make: %s, Model %s, Year: %s, Year: %d, Color: %s",
                ownerName, licensePlate, make, model, year, color);
    }

    // Check based on license plate (unique identifier)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return licensePlate.equals(vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return licensePlate.hashCode();
    }
}
