package com.techelevator.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Pet {
    private int petId;

    @NotBlank
    private String petName;

    private String adoptionInfo;

    @NotBlank
    private String petType;

    @Min(value = 1)
    private int agencyId;

    public Pet() { }

    public Pet(int petId, String petName, String adoptionInfo, String petType, int agencyId) {
        this.petId = petId;
        this.petName = petName;
        this.adoptionInfo = adoptionInfo;
        this.petType = petType;
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", adoptionInfo='" + adoptionInfo + '\'' +
                ", petType='" + petType + '\'' +
                ", agencyId=" + agencyId +
                '}';
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getAdoptionInfo() {
        return adoptionInfo;
    }

    public void setAdoptionInfo(String adoptionInfo) {
        this.adoptionInfo = adoptionInfo;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }
}
