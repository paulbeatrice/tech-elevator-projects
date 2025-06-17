package com.techelevator.ipod.dao;

import com.techelevator.ipod.exceptions.DaoException;
import com.techelevator.ipod.model.Playlist;
import com.techelevator.ipod.model.Song;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaylistDao implements PlaylistDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPlaylistDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Playlist createPlaylist(Playlist newPlaylist) {

        String sql = "INSERT INTO playlist VALUES (DEFAULT, ?) RETURNING playlist_id ;";

        try {

            int newPlaylistId = jdbcTemplate.queryForObject(sql, int.class, newPlaylist.getName());
            newPlaylist.setPlaylistId(newPlaylistId);

            return newPlaylist;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Couldn't create playlist with name " + newPlaylist.getName());
        }
    }

    @Override
    public void addSongToPlaylist(Playlist growingPlaylist, Song newSong) {
        int playlistId = growingPlaylist.getPlaylistId();
        int songId = newSong.getSongId();

        String sql = "INSERT INTO playlist_song VALUES (?, ?) ";
        try {
            jdbcTemplate.update(sql, playlistId, songId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Couldn't associate song #" + songId + " with playlist #" + playlistId);
        }
    }

    @Override
    public List<Song> getSongsFromPlaylist(Playlist playlist) {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM playlist_songs WHERE playlist_id = ?";
        SqlRowSet songResults = jdbcTemplate.queryForRowSet(sql, playlist.getPlaylistId());
        while (songResults.next()) {
            songs.add(mapRowToSong(songResults));
        }
        return songs;
    }

    @Override
    public Playlist renamePlaylist(Playlist renamedPlaylist) {
        String sql = "UPDATE playlist SET name = ? WHERE playlist_id = ? ";

        try {
            boolean found = jdbcTemplate.update(sql, renamedPlaylist.getName(), renamedPlaylist.getPlaylistId()) == 1;

            if (found) {
                return renamedPlaylist;
            }

            return null;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Couldn't rename playlist with ID #" + renamedPlaylist.getPlaylistId());
        }
    }

    @Override
    public void deletePlaylist(int playlistId) {
        String sqlDeleteSongsFirst = "DELETE FROM playlist_songs WHERE playlist_id = ? ;";
        String sqlDeletePlaylist = "DELETE FROM playlist WHERE playlist_id = ? ;";

        try {
            jdbcTemplate.update(sqlDeleteSongsFirst, playlistId);
            jdbcTemplate.update(sqlDeletePlaylist, playlistId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Couldn't create playlist with ID #" + playlistId);
        }
    }

    @Override
    public void removeSongFromPlaylist(Playlist playlist, Song goner) {
        String sql = "DELETE FROM playlist_songs WHERE playlist_id = ? AND song_id = ? ;";

        try {
            jdbcTemplate.update(sql, playlist.getPlaylistId(), goner.getSongId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database is down!");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Couldn't associate song #" + goner.getSongId() + " with playlist #" + playlist.getPlaylistId());
        }
    }

    private Song mapRowToSong(SqlRowSet sqlSong) {
        Song javaSong = new Song();

        javaSong.setTitle(sqlSong.getString("title"));
        javaSong.setArtist(sqlSong.getString("artist"));
        javaSong.setGenre(sqlSong.getString("genre"));
        if (sqlSong.getDate("release_date") != null) {
            javaSong.setReleaseDate(sqlSong.getDate("release_date").toLocalDate());
        }

        return javaSong;
    }
}
