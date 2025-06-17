package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        String sql = "SELECT * FROM people";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("person_name"),
                        resultSet.getDate("birthday") != null ? resultSet.getDate("birthday").toLocalDate() : null,
                        resultSet.getDate("deathday") != null ? resultSet.getDate("deathday").toLocalDate() : null,
                        resultSet.getString("biography"),
                        resultSet.getString("profile_path"),
                        resultSet.getString("home_page")
                )
        );
    }

    @Override
    public Person getPersonById(int id) {
        String sql = "SELECT * FROM person WHERE person_id = ?";
        try {
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) ->
                new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("person_name"),
                        resultSet.getDate("birthday") != null ? resultSet.getDate("birthday").toLocalDate() : null,
                        resultSet.getDate("deathday") != null ? resultSet.getDate("deathday").toLocalDate() : null,
                        resultSet.getString("biography"),
                        resultSet.getString("profile_path"),
                        resultSet.getString("home_page")
                ), id
        );
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
        return null;
    }
}

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        String sql = "SELECT * FROM person WHERE person_name LIKE ?";
        String queryName = useWildCard ? "%" + name + "%" : name;
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("person_name"),
                        resultSet.getDate("birthday") != null ? resultSet.getDate("birthday").toLocalDate() : null,
                        resultSet.getDate("deathday") != null ? resultSet.getDate("deathday").toLocalDate() : null,
                        resultSet.getString("biography"),
                        resultSet.getString("profile_path"),
                        resultSet.getString("home_page")
                )
        );

    }

    @Override
    public List<Person> getPersonsByCollectionName(String collection_name, boolean useWildCard) {
        String sql = "SELECT DISTINCT p.* " +
                "FROM person p " +
                "JOIN movie_actor ma ON p.person_id = ma.actor_id " +
                "JOIN movie m ON ma.movie_id = m.movie_id " +
                "JOIN collection c ON m.collection_id = c.collection_id " +
                "WHERE c.collection_name LIKE?";

        String queryName = useWildCard ? "%" + collection_name + "%" : collection_name;

        try {
            return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                    new Person(
                            resultSet.getInt("person_id"),
                            resultSet.getString("person_name"),
                            resultSet.getDate("birthday") != null ? resultSet.getDate("birthday").toLocalDate() : null,
                            resultSet.getDate("deathday") != null ? resultSet.getDate("deathday").toLocalDate() : null,
                            resultSet.getString("biography"),
                            resultSet.getString("profile_path"),
                            resultSet.getString("home_page")
                    ), queryName
            );
        } catch (Exception e) {
            throw new RuntimeException("SQL Error: " + e.getMessage(), e);
        }
    }
}
