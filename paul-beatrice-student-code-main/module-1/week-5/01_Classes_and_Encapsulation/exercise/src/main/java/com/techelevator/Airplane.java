package com.techelevator;

import java.lang.reflect.Constructor;

public class Airplane {

// Instance Variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    // Derived Attributes
    public int getAvailableFirstClassSeats(){
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    // Constructor

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
        this.bookedFirstClassSeats = 0; // Initially there are no booked seats
        this.bookedCoachSeats = 0; // " ^^^^^^^^^^^^^^^^^^  "
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }
    // Method to reserve seats

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (totalNumberOfSeats <= getAvailableFirstClassSeats()) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        } else {
            if (totalNumberOfSeats <= getAvailableCoachSeats()) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        }
    }

    //Getter for available first-class seats (derived)


}
