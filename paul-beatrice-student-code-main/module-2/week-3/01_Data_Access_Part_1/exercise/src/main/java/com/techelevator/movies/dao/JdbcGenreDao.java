package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        String sql = "SELECT genre_id, genre_name FROM genre";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Genre(resultSet.getInt("genre_id"), resultSet.getString("genre_name"))
        );
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "SELECT genre_id, genre_name FROM genre WHERE genre_id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) ->
            new Genre(resultSet.getInt("genre_id"), resultSet.getString("genre_name")), id
        );
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        String sql = "SELECT genre_id, genre_name FROM genre WHERE genre_name LIKE ?";
        String queryName = useWildCard ? "%" + name + "%" : name;
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Genre(resultSet.getInt("genre_id"), resultSet.getString("genre_name")), queryName
        );
    }
}
