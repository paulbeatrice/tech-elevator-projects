package com.techelevator.model;
import java.util.List;
public class Product {

    private Integer id;
    private String name;
    private String description;

    private List<Review> reviews; // Holds associated reviews



    public Product() { }

    public Product(Integer id, String name, String description, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reviews = reviews;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
