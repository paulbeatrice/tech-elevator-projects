package com.techelevator.ipod.dao;

import com.techelevator.ipod.model.Playlist;
import com.techelevator.ipod.model.Song;

import java.util.List;

public interface PlaylistDao {

    // Creates
    Playlist createPlaylist(Playlist newPlaylist);
    void addSongToPlaylist(Playlist growingPlaylist, Song newSong);

    // Retrieve
    List<Song> getSongsFromPlaylist(Playlist playlist);

    // Update
    Playlist renamePlaylist(Playlist renamedPlaylist);

    // Deletes
    void deletePlaylist(int playlistId);
    void removeSongFromPlaylist(Playlist playlist, Song goner);

}
