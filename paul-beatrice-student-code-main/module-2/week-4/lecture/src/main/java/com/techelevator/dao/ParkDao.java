package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Park;

import java.util.List;

public interface ParkDao {

    Park getParkById(int parkId);

    /**
     * Get parks by state. Returns an empty list if state
     * abbreviation does not exist.
     * @param stateAbbreviation
     * @return
     */
    List<Park> getParksByState(String stateAbbreviation);

    /**
     * Create a park, ignoring parkId in input parameter
     *  Throws DaoException on any invalid fields
     * @param park
     * @return
     */
    Park createPark(Park park) throws DaoException;

    /**
     * Updates park. Uses parkId field to determine which
     *  park to update.
     *  Throws DaoException on any invalid fields
     * @param park
     * @return
     */
    Park updatePark(Park park) throws DaoException;

    /**
     * Delete by city id. Does not delete any records in
     *  any referenced join tables. See unlinkParkState method.
     * @param parkId
     * @return
     * @throws DaoException
     */
    int deleteParkById(int parkId) throws DaoException;

    /**
     * Add park association with state
     *  Throws DaoException if parameters are not valid
     *  foreign keys
     * @param parkId
     * @param stateAbbreviation
     */
    void linkParkState(int parkId, String stateAbbreviation) throws DaoException;

    /**
     * Remove association with state.
     * @param parkId
     * @param stateAbbreviation
     */
    void unlinkParkState(int parkId, String stateAbbreviation);
}
