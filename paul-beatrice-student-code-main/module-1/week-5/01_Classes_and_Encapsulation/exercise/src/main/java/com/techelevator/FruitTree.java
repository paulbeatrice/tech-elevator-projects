package com.techelevator;

public class FruitTree {

    // Instance Variables

    private String typeOfFruit;
    private int piecesOfFruitLeft;

    // Constructor

    public FruitTree (String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    // Getter for typeOfFruit
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    // Getter and Setter for piecesOfFruitLeft


    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public void setPiecesOfFruitLeft(int piecesOfFruitLeft) {
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    // Method to pick fruit from the tree

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if(numberOfPiecesToRemove <= piecesOfFruitLeft) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true; // successfully picked fruit
        } else {
            return false; // no pieces left to pick
        }
    }

}
