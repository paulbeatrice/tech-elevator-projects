package com.lendingcatalog;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private String spotType; // Defines parking spot as compact or regular

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false; // initializes it as unoccupied
    }

    // Getters


    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public void occupySpot() {
        if (isOccupied) {
            throw new IllegalStateException("Parking spot is already occupied.");
        }
        this.isOccupied = true;  // sets space to occupied if it is occupied
    }
    public void vacateSpot() {
        this.isOccupied = false; // allows user to free up spot
    }

    @Override
    public String toString() {
        return "Spot " + spotNumber + ": " + spotType + (isOccupied ? " (Occupied)" : "(Vacant)");
    }


}
