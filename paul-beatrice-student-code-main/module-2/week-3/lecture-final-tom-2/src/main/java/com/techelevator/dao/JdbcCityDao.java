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


    private JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
        String sql = "SELECT * FROM city WHERE city_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, cityId);
        if (result.next()) {
            return mapRowToCity(result);
        }

        return null;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        return null;
    }

    @Override
    public City createCity(City city) {

        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     " VALUES (?, ?, ?, ?) RETURNING city_id;";

        String sql2 = "INSERT INTO city VALUES (DEFAULT, ?, ?, ?, ?) RETURNING city_id;";

//        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());
//        result.next();
//        int newCityId = result.getInt("city_id");
//        city.setCityId(newCityId);
//        city.setCityId(newCityId);
//        return city;

        int newCityId = jdbcTemplate.queryForObject(sql, int.class, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());
        city.setCityId(newCityId);
        return city;
//        return getCityById(newCityId);

    }

    @Override
    public City updateCity(City city) {
        String sql = "UPDATE city SET city_name = ?, state_abbreviation = ?, population = ?, area = ? " +
                     "WHERE city_id = ?"; // guarantees I only change one record

        int rowsAffected = jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea(), city.getCityId());

        if (rowsAffected != 1) {
            throw new DaoException("Couldn't update the record!");
        }

        return city;
    }

    @Override
    public int deleteCityById(int cityId) {
        String sql = "DELETE FROM city WHERE city_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql, cityId);

        if (rowsAffected != 1) {
            throw new DaoException("DELETE failed! -- " + rowsAffected + " rows affected.");
        }

        return rowsAffected;
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
