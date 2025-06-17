package com.techelevator;

public abstract class Wall {
    private final String name;
    private final String color;

    //Constructor
    public Wall (String name, String color) {
        this.name = name;
        this.color = color;
    }
    //Getters and Setters for name & color
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    // Abstract method for calculating area
    public abstract int getArea();
}
