package com.techelevator;

public class TriangleWall extends Wall {
    private final int base;
    private final int height;

    //Constructor
    public TriangleWall( String name, String color, int base, int height) {
        super(name, color); // call superclass constructor
        this.base = base;
        this.height = height;
    }

    //Getter for base
    public int getBase() {
        return base;
    }

    //Getter for height
    public int getHeight() {
        return height;
    }

    //Implement the getArea method
    @Override
    public int getArea() {
        return (base * height) / 2;
    }

    //override toString method
    @Override
    public String toString() {
        return getName() + " (" + base + "x" + height + ") triangle";
    }
}
