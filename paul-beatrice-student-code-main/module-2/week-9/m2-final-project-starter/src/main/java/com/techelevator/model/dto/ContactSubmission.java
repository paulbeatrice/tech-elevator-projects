package com.techelevator.model.dto;

import java.time.LocalDateTime;

public class ContactSubmission {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String businessName;
    private String businessWebsite;
    private String socialPlatform;
    private String socialLink;
    private String message;
    private LocalDateTime submittedAt;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getBusinessWebsite() {
        return businessWebsite;
    }
    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }
    public String getSocialPlatform() {
        return socialPlatform;
    }
    public void setSocialPlatform(String socialPlatform) {
        this.socialPlatform = socialPlatform;
    }
    public String getSocialLink() {
        return socialLink;
    }
    public void setSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
