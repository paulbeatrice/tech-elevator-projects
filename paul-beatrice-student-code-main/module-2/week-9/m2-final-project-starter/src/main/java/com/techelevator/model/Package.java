package com.techelevator.model;

import java.math.BigDecimal;

public class Package {
    private int PackageId;
    private String name;
    private String description;
    private BigDecimal price;

    public Package() {}

    public Package(int packageId, String name, String description, BigDecimal price) {
        this.PackageId = packageId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
