package com.techelevator;

public class Elevator {

    //Instance Variables

    private int currentFloor;
    private int numberOfFloors;
    private boolean isDoorOpen;

    //Constructor
    public Elevator(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.currentFloor = 1; // default current floor starts on floor one
        this.isDoorOpen = false; // door is default to shut
    }

     // methods

    public void openDoor() {
        isDoorOpen = true;
    }

    public void closeDoor() {
        isDoorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!isDoorOpen && desiredFloor > currentFloor && desiredFloor <= numberOfFloors) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        if (!isDoorOpen && desiredFloor < currentFloor && desiredFloor >= 1) {
            currentFloor = desiredFloor;
        }
    }

    //Getters for current Status

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
}
