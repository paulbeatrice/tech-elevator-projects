package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.City;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

    public JdbcCityDao(DataSource dataSource) {

    }

    @Override
    public int getCityCount() {
        return -1;
    }

    @Override
    public List<String> getCityNames() {
        return null;
    }

    @Override
    public City getRandomCity() {
        return null;
    }

    @Override
    public City getCityById(int cityId) {
        return null;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        return null;
    }

    @Override
    public City createCity(City city) {
        return null;
    }

    @Override
    public City updateCity(City city) {
        return null;
    }

    @Override
    public int deleteCityById(int cityId) {
        return -1;
    }

    private City mapRowToCity(SqlRowSet rowSet) {
        City city = new City();
        city.setCityId(rowSet.getInt("city_id"));
        city.setCityName(rowSet.getString("city_name"));
        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));
        return city;
    }
}
