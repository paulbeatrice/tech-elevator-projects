package com.techelevator;

public class Person {

    //Instance Variables (all must be private)
   private String firstName;

   private String lastName;

   private String email;

   private String section;

   private int age;

   private boolean rightHanded;


// CONSTRUCTOR
   // always public (for our TE purposes)
   // no return type at all (not even "void", just skip the placeholder)
   // must be named same as class name (PascalCase)

   public Person(String firstName, String lastName, String email) {
      // set some default values

      this.firstName = "John";
      this.lastName = "Deere";
      this.email = "noreplay@somewhere.com";

      //set some default values (no corresponding input values)
      section = "Java Green";
      age = 18;
      rightHanded = true;
      System.out.println("Created a person!");
   }


   //Default constructor

   public Person() {
      
   }


























   public void setRightHanded(boolean rightHanded) {
      this.rightHanded = rightHanded;
   }

   // if boolean getter use is and not get

   public boolean isRightHanded() {
      return rightHanded;
   }


   // Getter
   // returns same data type as intance variable
   // no input

   public String getFirstName() {
      return firstName;
   }

   // SETTER
   // takes in the new value (same data type as instance variable)
   // changes instance variable to match incoming new value
   //no output!

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
