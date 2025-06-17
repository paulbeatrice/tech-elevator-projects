package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonApp {

    // "main" + Tab:

    public static void main(String[] args) {
        // 3 objects (instances of the Person Class)
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        Scanner keyboard = new Scanner(System.in);
        List<String> instructors = new ArrayList<>();

        String p1FirstNameIs = p1.getFirstName();
        p2.getFirstName();
        p3.getFirstName();


        System.out.println("Person 1 is named " + p1.getFirstName());
        System.out.println("Person 2 is named " + p2.getFirstName());
        System.out.println("Person 3 is named" + p3.getFirstName());


        p1.setFirstName("Tom");
        p2.setFirstName("Daniel");
        p3.setFirstName("Walt");

        System.out.println("Person 1 is named " + p1.getFirstName());
        System.out.println("Person 2 is named " + p2.getFirstName());
        System.out.println("Person 3 is named" + p3.getFirstName());


    }
}
