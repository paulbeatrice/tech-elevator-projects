package com.techelevator;

public class HomeworkAssignment {

    // INSTANCE VARIABLES (all private)
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;


    // CONSTRUCTOR
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }


    // Derived Property (NO INSTANCE VARIABLE!)
    public String getLetterGrade() {
        double score = (double)earnedMarks / (double)possibleMarks;

        if (score >= 0.9) {
            return "A";
        } else if (score >= 0.8) {
            return "B";
        } else if (score >= 0.7) {
            return "C";
        } else if (score >= 0.6) {
            return "D";
        } else {
            return "F";
        }
    }

    // GETTERs
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    // SETTER
    public void setEarnedMarks(int newValue) {
        earnedMarks = newValue;
    }

}
