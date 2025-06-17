package com.techelevator;

public class HomeworkAssignment {

    // Instance variables:

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    // Constructor

    public HomeworkAssignment (int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    // Getters & Setters

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public void setPossibleGrades(int possibleMarks) {
        this.possibleMarks = possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    // Derived getter for letterGrade

    public String getLetterGrade() {
        double percentage = ((double) earnedMarks / possibleMarks) * 100;

        if(percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
