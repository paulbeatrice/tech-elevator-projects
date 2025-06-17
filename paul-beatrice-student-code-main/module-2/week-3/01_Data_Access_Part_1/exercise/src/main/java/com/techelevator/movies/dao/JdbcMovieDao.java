package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Movie(
                        resultSet.getInt("movie_id"),
                        resultSet.getString("title"),
                        resultSet.getString("overview"),
                        resultSet.getString("tagline"),
                        resultSet.getString("poster_path"),
                        resultSet.getString("home_page"),
                        resultSet.getDate("release_date").toLocalDate(),
                        resultSet.getInt("length_minutes"),
                        resultSet.getInt("director_id"),
                        resultSet.getInt("collection_id")
                )
        );
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "SELECT * FROM movie WHERE movie_id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) ->
                new Movie(
                        resultSet.getInt("movie_id"),
                        resultSet.getString("title"),
                        resultSet.getString("overview"),
                        resultSet.getString("tagline"),
                        resultSet.getString("poster_path"),
                        resultSet.getString("home_page"),
                        resultSet.getDate("release_date").toLocalDate(),
                        resultSet.getInt("length_minutes"),
                        resultSet.getInt("director_id"),
                        resultSet.getInt("collection_id")
                ), id
        );
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        String sql = "SELECT * FROM movie WHERE title LIKE ?";
        String queryTitle = useWildCard ? "%" + title + "%" : title;
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Movie(
                        resultSet.getInt("movie_id"),
                        resultSet.getString("title"),
                        resultSet.getString("overview"),
                        resultSet.getString("tagline"),
                        resultSet.getString("poster_path"),
                        resultSet.getString("home_page"),
                        resultSet.getDate("release_date").toLocalDate(),
                        resultSet.getInt("length_minutes"),
                        resultSet.getInt("director_id"),
                        resultSet.getInt("collection_id")
                ), queryTitle
        );
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear, int endYear, boolean useWildCard) {
        String sql = "SELECT m.* FROM movie m " + "JOIN directors d ON m.director_id = d.director_id " +
                "WHERE d.name LIKE ? AND YEAR(m.release_date) BETWEEN ? AND ?";
        String queryDirectorName = useWildCard ? "%" + directorName + "%" : directorName;
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Movie(
                        resultSet.getInt("movie_id"),
                        resultSet.getString("title"),
                        resultSet.getString("overview"),
                        resultSet.getString("tagline"),
                        resultSet.getString("poster_path"),
                        resultSet.getString("home_page"),
                        resultSet.getDate("release_date").toLocalDate(),
                        resultSet.getInt("length_minutes"),
                        resultSet.getInt("director_id"),
                        resultSet.getInt("collection_id")
                ), queryDirectorName, startYear, endYear
        );

    }
}
