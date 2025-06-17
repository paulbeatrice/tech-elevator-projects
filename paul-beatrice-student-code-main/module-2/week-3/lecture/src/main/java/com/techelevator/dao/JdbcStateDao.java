package com.techelevator.dao;

import com.techelevator.model.State;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

//step 3 -- create a class that implements StateDao
public class JdbcStateDao implements StateDao {

    //SRP: Single Responsibility Principle -- you have one job you need to do that one job well

    private JdbcTemplate jdbcTemplate;





    public JdbcStateDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); // anytime we use jdbcTemplate it will know that dataSource will be UnitedStatesDB
    }

    @Override
    public State getStateByAbbreviation(String stateAbbreviation) {

        State state = null;


        String sql = "SELECT * " +
                     "FROM state " +
                     "WHERE state_abbreviation = ?;"; //parameterized query - helps prevent SQL injection Attacks
                    // never concatenate instead you use a '?' that gets substituted out at the last second (much safer)
                    // always think of your users as idiots or jerks

                    //jdbcTemplate will prevent you from SQL injection attacks



                            // variable number of arguments (varargs)
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // ^^ this does one roundtrip to the database


        if(results.next()){             //do we have any results? if not skip and return state
            state = mapRowToState(results); // if returns true we return this instead
        }

        return state;
    }

    @Override
    public State getStateByCapital(int cityId) {
        return null;
    }

    @Override
    public List<State> getStates() {
        return null;
    }

    private State mapRowToState(SqlRowSet rowSet) {    //this method takes one SQL rowSet into one state object & presumes cursor is set to correct row

        String stateAbbreviation = rowSet.getString("state_abbreviation");
        String stateName = rowSet.getString("state_name");

        State state = new State(stateAbbreviation, stateName);
        return state;
    }
}
