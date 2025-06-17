package com.techelevator.dao;

import com.techelevator.model.State;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


// SRP: Single Responsibility Principle

public class JdbcStateDao implements StateDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcStateDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public State getStateByAbbreviation(String stateAbbreviation) {

        State state = null;

        String sql = "SELECT * " +
                     "FROM state " +
                     "WHERE state_abbreviation = ? ;" ; // Parameterized Query --> Helps prevent SQL Injection Attacks

        //                                                   variable number of arguments (varargs)
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        if(results.next()){ // Do we have any results?
            state = mapRowToState(results);
        }

        return state;
    }

    @Override
    public State getStateByCapital(int cityId) {
        State correctState = null;

        String sql = "SELECT * FROM state WHERE capital = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, cityId);

        if (result.next()) {
            correctState = mapRowToState(result);
        }

        return correctState;
    }

    @Override
    public List<State> getStates() {
        String sql = "SELECT * FROM state;";

        List<State> output = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            output.add(mapRowToState(results));
//            State currentState = mapRowToState(results);
//            output.add(currentState);
        }

        return output;
    }


    // Turns one SqlRowSet row into one State object (presumes the cursor is set to the correct row)
    private State mapRowToState(SqlRowSet rowSet) {

        String stateAbbreviation = rowSet.getString("state_abbreviation");
        String stateName = rowSet.getString("state_name");
        BigDecimal salesTax = rowSet.getBigDecimal("sales_tax");

        State state = new State(stateAbbreviation, stateName, salesTax);
        return state;
    }
}
