package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.City;

import java.util.List;

public interface CityDao {

    City getCityById(int cityId);

    /**
     * Get cities by state. Returns and empty list if state
     * abbreviation does not exist.
     * @param stateAbbreviation
     * @return
     */
    List<City> getCitiesByState(String stateAbbreviation);

    /**
     * Create a city, ignoring cityId in input parameter
     *  Throws DaoException on any invalid fields
     * @param city
     * @return retrieved city after creating
     */
    City createCity(City city) throws DaoException;

    /**
     * Update city. Uses cityId field to determine which
     *  city to update.
     *  Throws DaoException on any invalid fields
     * @param city
     * @return retrieved city after updating
     */
    City updateCity(City city) throws DaoException;

    /**
     * Delete by city id.
     * @param cityId
     * @return number of rows affected
     */
    int deleteCityById(int cityId);
}
