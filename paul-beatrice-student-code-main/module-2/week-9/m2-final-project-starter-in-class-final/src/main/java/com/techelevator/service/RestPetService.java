package com.techelevator.service;

import com.techelevator.model.dto.DogDto;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RestPetService implements PetService {
    // https://dog.ceo/api/breeds/image/random

    private final String API_BASE_URL = "https://dog.ceo";
    private final RestClient restClient = RestClient.create(API_BASE_URL);


    @Override
    public DogDto getDogPic() {
        DogDto dogPic = restClient
                        .get()
                        .uri("/api/breeds/image/random")
                        .retrieve()
                        .body(DogDto.class);

        return dogPic;
    }

    public DogDto getRandomDogPic() {
        List<DogDto> allDogsGoToHeaven = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            allDogsGoToHeaven.add(getDogPic());
        }

        Random rando = new Random();
        int randomIndex = rando.nextInt(allDogsGoToHeaven.size());

        return allDogsGoToHeaven.get(randomIndex);
    }


}
