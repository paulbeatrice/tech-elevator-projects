package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    public JdbcParkDao(DataSource dataSource) {

    }

    @Override
    public int getParkCount() {
        return -1;
    }
    
    @Override
    public List<String> getParkNames() {
        return null;
    }
    
    @Override
    public Park getRandomPark() {
        return null;
    }

    @Override
    public List<Park> getParksWithCamping() {
        return null;
    }

    @Override
    public Park getParkById(int parkId) {
        return null;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return null;
    }

    @Override
    public Park createPark(Park park) {
        throw new DaoException("createPark() not implemented");
    }

    @Override
    public Park updatePark(Park park) {
        throw new DaoException("updatePark() not implemented");
    }

    @Override
    public int deleteParkById(int parkId) {
        throw new DaoException("deleteParkById() not implemented");
    }

    @Override
    public void linkParkState(int parkId, String stateAbbreviation) {
        throw new DaoException("linkParkState() not implemented");
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
