package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

public interface CityDao {


    // R:
    int getCityCount();
    List<String> getCityNames();
    City getRandomCity();
    City getCityById(int cityId);
    List<City> getCitiesByState(String stateAbbreviation);

    // C:
    City createCity(City city);

    // U:
    City updateCity(City city);

    // D:
    int deleteCityById(int cityId);
}
