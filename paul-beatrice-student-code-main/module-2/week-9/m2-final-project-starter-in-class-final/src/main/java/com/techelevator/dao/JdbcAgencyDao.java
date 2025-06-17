package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAgencyDao implements AgencyDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAgencyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Agency getAgencyById(int agencyId) {
        String sql = "SELECT * FROM agency WHERE agency_id = ? ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, agencyId);
        if (result.next()) {
            // Found it!
            Agency a = new Agency();
            a.setAgencyId(result.getInt("agency_id"));
            a.setAgencyName(result.getString("agency_name"));
            a.setAddress(result.getString("address"));
            a.setAgencyPolicy(result.getString("policy"));

            return a;
        }

        return null; // didn't find it!
    }

    @Override
    public Agency addAgency(Agency newAgency) {
        String sql = "INSERT INTO agency VALUES (DEFAULT, ?, ?, ?) RETURNING agency_id; ";
        try {
            int newId = jdbcTemplate.queryForObject(sql, int.class, newAgency.getAgencyName(), newAgency.getAddress(), newAgency.getAgencyPolicy());
            newAgency.setAgencyId(newId);

            return newAgency;
        } catch (DataIntegrityViolationException e) {
            System.out.println("Whoops");
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("System is down!");
        }

        return null;
    }

    @Override
    public int updateAgency(Agency changedAgency) {
        String sql = "UPDATE agency SET agency_name = ?, address = ?, policy = ? WHERE agency_id = ?; ";

        try {
            int rowsAffected = jdbcTemplate.update(sql, changedAgency.getAgencyName(), changedAgency.getAddress(), changedAgency.getAgencyPolicy(), changedAgency.getAgencyId());
            if (rowsAffected != 1) {
                throw new DaoException("Not found! Or maybe found too many?");
            }
            return rowsAffected;
        } catch (DataIntegrityViolationException e) {
            System.out.println("Whoops");
            throw new DaoException("You have no integrity");
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("System is down!");
        }

        return 0;
    }

    @Override
    public int removeAgency(int agencyPrimaryKey) {
        String sql = "DELETE FROM agency WHERE agency_id = ?; ";
        try {
            return jdbcTemplate.update(sql, agencyPrimaryKey);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Whoops");
            throw new DaoException("You have no integrity");
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("System is down!");
        }

        return 0;
    }
}
