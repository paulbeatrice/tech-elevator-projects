package com.techelevator.ipod.dao;

import com.techelevator.ipod.exceptions.DaoException;
import com.techelevator.ipod.model.Song;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSongDao implements SongDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSongDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Song> getAllSongs() {
        List<Song> allSongs = new ArrayList<>();

        String sql = "SELECT * FROM song;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                allSongs.add(mapRowToSong(results));
            }

            return allSongs;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        }
    }

    @Override
    public Song getSongById(int songId) {
        String sql = "SELECT * FROM song WHERE song_id = ? ;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, songId);

            Song thisSong = null;
            if (result.next()) {
                thisSong = mapRowToSong(result);
            }

            return thisSong;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        }
    }

    private Song mapRowToSong(SqlRowSet row) {
        int songId = row.getInt("song_id");
        String title = row.getString("title");
        String artist = row.getString("artist");
        String genre = row.getString("genre");

        LocalDate releaseDate = null;
        if (row.getDate("release_date") != null) {
            releaseDate = row.getDate("release_date").toLocalDate();
        }

        return new Song(songId, title, artist, releaseDate, genre);
    }

}
