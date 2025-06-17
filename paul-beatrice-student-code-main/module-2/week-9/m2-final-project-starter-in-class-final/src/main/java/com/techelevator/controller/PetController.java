package com.techelevator.controller;

import com.techelevator.service.PetService;
import com.techelevator.service.RestPetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @GetMapping("/newDog")
    public String hereGoesNothing() {
        PetService ps = new RestPetService();
        String imgSrc = ps.getDogPic().getMessage();

        return "<html><body><h1>THIS IS MY DOG</h1><img src=\"" + imgSrc + "\" /></body></html>";
    }

}
