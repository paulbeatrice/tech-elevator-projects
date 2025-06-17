package com.techelevator.service;

public class ServiceTestApp {

    public static void main(String[] args) {
        RestPetService rps = new RestPetService();
        System.out.println(rps.getDogPic());

        System.out.println(rps.getRandomDogPic());
    }
}
