package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;


//this is the features of the application - if we give it a state it should give us the number of cities in the state, etc.
public interface CityDao {
    
    int getCityCount();

    List<String> getCityNames();

    City getRandomCity();

    City getCityById(int cityId);

    List<City> getCitiesByState(String stateAbbreviation);

    City createCity(City city);

    City updateCity(City city);

    int deleteCityById(int cityId);
}
