package com.techelevator.ipod.dao;

import com.techelevator.ipod.exceptions.DaoException;
import com.techelevator.ipod.model.Playlist;
import com.techelevator.ipod.model.Song;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
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
        return List.of();
    }

    @Override
    public Playlist renamePlaylist(Playlist renamedPlaylist) {
        return null;
    }

    @Override
    public void deletePlaylist(int playlistId) {

    }

    @Override
    public void removeSongFromPlaylist(Playlist playlist, Song goner) {

    }
}
