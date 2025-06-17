package model;

import java.math.BigDecimal;

public class Package {
    private int packageId;
    private String name;
    private String description;
    private BigDecimal price;

    public Package() {

    }

    public Package(int packageId, String name, String description, BigDecimal price) {
        this.packageId = packageId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
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

    @Override
    public String toString() {
        return String.format("Package{packageId=%d, name='%s', description='%s', price=%s}",
                packageId, name, description, price);
    }
}


