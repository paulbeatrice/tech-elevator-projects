package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonApp {

    //  "main" + Tab:
    public static void main(String[] args) {
        // 3 Objects (instances of the Person class)
        Person p1 = new Person("Tom", "Medvitz", "tom@techelevator.com");
        Person p2 = new Person("Steve");
        Person p3 = new Person();

        System.out.println("Person 1 is named " + p1.getFirstName());
        System.out.println("Person 2 is named " + p2.getFirstName());
        System.out.println("Person 3 is named " + p3.getFirstName());

        p1.setFirstName("Tom");
        p2.setFirstName("Daniel");
        p3.setFirstName("Walt");

        System.out.println("Person 1 is named " + p1.getFullName());
        System.out.println("Person 2 is named " + p2.getFullName());
        System.out.println("Person 3 is named " + p3.getFullName());

        System.out.println("===============================");

        p1.setAge(45);
        System.out.println("Tom is: " + p1.getAge() + " years old!");
        System.out.println("But wait! Today is his birthday!");

        p1.haveBirthday();

        System.out.println("Now Tom is: " + p1.getAge() + " years old!");

        System.out.println("===============================");
        p2.setLastName("Commins");
        System.out.println(p2.greeting());

    }

}
