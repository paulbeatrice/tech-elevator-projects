package com.techelevator;

public class Exercise01_TestGrading {

    /*
    Grade-o-matic Incorporated has a program to grade student tests.
    The problems below ask you to implement the logic for returning a grade based on a student's test score.
     */

    /*
    Grade-o-matic v1.0 scores tests as pass-fail.
    A score of 70 or higher is a passing score. Anything lower is a failing score.
    Return true for a passing score and false for a failing score.

    Examples:
    gradeTestPassFail(90) ➔ true
    gradeTestPassFail(70) ➔ true
    gradeTestPassFail(45) ➔ false
     */
    public boolean gradeTestPassFail(int score) {
        if (score >= 70) {
            return true;
        }
        if (score < 70) {
            return false;
        }
        return false;
    }


    /*
    Grade-o-matic received numerous requests from customers to grade using a point-based system.
    Grade-o-matic v2.0 can now also score tests on a 0-3 scale.
    Implement the logic to grade tests using this new scale:
        For a score of 90 or higher, return 3
        For a score of 50-89, return 2
        For a score of 25-49, return 1
        For a score of less than 25, return 0

    Examples:
    gradeTestNumeric(90) ➔ 3
    gradeTestNumeric(70) ➔ 2
    gradeTestNumeric(45) ➔ 1
    gradeTestNumeric(10) ➔ 0
     */
        public int gradeTestNumeric(int testScore) {
            if (testScore >= 90) {
                return 3;
            }
            if (testScore >= 50 && testScore <= 89) {
                return 2;
            }
            if (testScore >= 25 && testScore <= 49) {
                return 1;
            }
            if (testScore <= 25) {
                return 0;
            }
            return 0;

        }



    /*
    Grade-o-matic has received even more requests to grade using the classic letter scale.
    Grade-o-matic v3.0 can now score tests on a letter scale.
    Implement the logic to grade tests using this new scale:
        For a score of 90 or higher, return 'A'
        For a score of 80-89, return 'B'
        For a score of 70-79, return 'C'
        For a score of 60-69, return 'D'
        For a score less than 60, return 'F'

    Examples:
    gradeTestLetter(90) ➔ 'A'
    gradeTestLetter(70) ➔ 'C'
    gradeTestLetter(45) ➔ 'F'
     */
        public char gradeTestLetter(int gradeScore) {
            if (gradeScore >= 90) {
                return 'A';
            }
            if (gradeScore >= 80 && gradeScore <= 89) {
                return 'B';
            }
            if (gradeScore >= 70 && gradeScore <= 79) {
                return 'C';
            }
            if (gradeScore >= 60 && gradeScore <= 69) {
                return 'D';
            }
            if (gradeScore <= 60) {
                return 'F';
            }
            return 'F';
        }
}
