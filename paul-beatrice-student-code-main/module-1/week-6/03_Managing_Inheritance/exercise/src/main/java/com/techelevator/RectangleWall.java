package com.techelevator;

public class RectangleWall extends Wall {
    private final int length;
    private final int height;

    //Constructor
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color); // Call superclass constructor
        this.length = length;
        this.height = height;
    }
    //Getter for length
    public int getLength() {
        return length;
    }

    //Getter for height
    public int getHeight() {
        return height;
    }

    //Implement the getArea method
    @Override
    public int getArea() {
        return length * height;
    }
    //Override toString method
    @Override
    public String toString() {
        return getName() + " (" + length + "x" + height + ") rectangle";
    }
}
