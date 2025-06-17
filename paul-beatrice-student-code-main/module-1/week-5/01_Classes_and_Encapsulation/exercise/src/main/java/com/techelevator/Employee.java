package com.techelevator;

public class Employee {

    // Instance Variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Constructor

    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    //Derived fullName attribute

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    //Getter for employeeID
    public int getEmployeeId() {
        return employeeId;
    }

    //Getter and Setter for firstName


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Getter and Setter for Department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Getter and Setter for annualSalary
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    // Method to raise Salary
    public void raiseSalary(double percent) {
        this.annualSalary += this.annualSalary * (percent/100);
    }
}
