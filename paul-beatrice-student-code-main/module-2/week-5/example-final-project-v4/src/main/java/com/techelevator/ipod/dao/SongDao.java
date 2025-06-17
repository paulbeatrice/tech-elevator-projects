package com.techelevator.ipod.dao;

import com.techelevator.ipod.model.Song;

import java.util.List;

public interface SongDao {

    // Retrieve:
    List<Song> getAllSongs();
    Song getSongById(int songId);

}
