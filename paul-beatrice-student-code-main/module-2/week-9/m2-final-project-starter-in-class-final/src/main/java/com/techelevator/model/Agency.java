package com.techelevator.model;

import jakarta.validation.constraints.NotNull;

public class Agency {
    private int agencyId;

    @NotNull
    private String agencyName;

    @NotNull
    private String address;

    @NotNull
    private String agencyPolicy;

    public Agency() { }

    public Agency(int agencyId, String agencyName, String address, String agencyPolicy) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.address = address;
        this.agencyPolicy = agencyPolicy;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "agencyId=" + agencyId +
                ", agencyName='" + agencyName + '\'' +
                ", address='" + address + '\'' +
                ", agencyPolicy='" + agencyPolicy + '\'' +
                '}';
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgencyPolicy() {
        return agencyPolicy;
    }

    public void setAgencyPolicy(String agencyPolicy) {
        this.agencyPolicy = agencyPolicy;
    }
}
