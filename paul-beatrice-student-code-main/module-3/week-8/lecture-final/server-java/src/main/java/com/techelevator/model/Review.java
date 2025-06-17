package com.techelevator.model;

public class Review {

    private Integer id;
    private Integer productId;
    private String reviewer;
    private String title;
    private String review;
    private int rating;
    private boolean favorited;

    public Review() { }

    public Review(Integer id, Integer productId, String reviewer, String title, String review, int rating, boolean favorited) {
        this.id = id;
        this.productId = productId;
        this.reviewer = reviewer;
        this.title = title;
        this.review = review;
        this.rating = rating;
        this.favorited = favorited;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
