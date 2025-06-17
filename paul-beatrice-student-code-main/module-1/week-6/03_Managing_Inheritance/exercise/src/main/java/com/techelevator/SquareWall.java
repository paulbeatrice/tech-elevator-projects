package com.techelevator;

public class SquareWall extends RectangleWall{
    //Constructor for SquareWall
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength); // use sideLength for both length and height
    }
    //Override toString method
    @Override
    public String toString() {
        return getName() + " (" + getLength() + "x" + getLength() + ") square";
    }
}
