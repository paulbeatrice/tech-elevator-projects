package com.techelevator;

public class Person {
    // INSTANCE VARIABLES! (all must be private)
    private String firstName;
    private String lastName;
    private String email;
    private String section;
    private int age;

    private boolean rightHanded;


    // DERIVED PROPERTY
    //    NO INSTANCE VARIABLE!!!
    //    "fake getter"
    public String getFullName() {
        return firstName + " " + lastName;
    }


    // OTHER Methods! (Things that make this object interesting)
    public void haveBirthday() {
        age++;
    }

    public String greeting() {
        return "Hello! My name is " + getFullName();
    }


    // CONSTRUCTOR:
    //   always public (for our TE purposes)
    //   no return type at all (not even "void", just skip the placeholder)
    //   must be named same as class name (PascalCase)
    public Person(String firstName, String lastName, String email) {
        // use incoming values to set instance variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        // set some default values (no corresponding input values)
        section = "Java Green";
        age = 18;
        rightHanded = true;

        System.out.println("Created a person named " + firstName);
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }


    // DEFAULT CONSTRUCTOR
    public Person() { }



    public void setRightHanded(boolean newValue) {
        this.rightHanded = newValue;
    }

    public boolean isRightHanded() {
        return rightHanded;
    }

    // GETTER:
    //  returns same data type as Instance Variable
    //  no input!
    public String getFirstName() {
        return firstName;
    }

    // SETTER
    //   takes in the new value (same data type as instance variable)
    //   changes instance variable to match incoming new value
    //   no output!
    public void setFirstName(String incomingFirstName) {
        firstName = incomingFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
