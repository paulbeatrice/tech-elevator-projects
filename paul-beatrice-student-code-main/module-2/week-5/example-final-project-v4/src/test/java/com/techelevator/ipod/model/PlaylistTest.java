package com.techelevator.ipod.model;

import com.techelevator.ipod.exceptions.EmptyPlaylistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PlaylistTest {

    // ARRANGE / ACT / ASSERT

    @Test
    public void test_playlist_accepts_new_song() {
        // 1. ARRANGE inputs
        Playlist p = new Playlist("Test Playlist");
        Song s = new Song("Test Title", "Test Artist", LocalDate.parse("1994-01-01"), "Test Genre");

        // 2. ACT (test the method you're trying to test)
        boolean result = p.enqueue(s);

        // 3. ASSERT (make sure you get what you expected)
        Assertions.assertTrue(result);   // we expect that it's TRUE that we were able to enqueue the song!
    }

    @Test
    public void empty_playlist_throws_exception_old_school(){
        // 1. ARRANGE inputs
        Playlist p = new Playlist("Test Playlist");

        // 2. ACT
        try {
            p.play();
            Assertions.fail("Should've thrown an exception but didn't!");
        } catch (EmptyPlaylistException e) {

        }
    }

    @Test
    public void add_3_songs_play_3_songs() {
        Playlist p = new Playlist("Test Playlist");
        Song s = new Song("Test Title", "Test Artist", LocalDate.parse("1994-01-01"), "Test Genre");

        // 2. ACT (test the method you're trying to test)
        p.enqueue(s);
        p.enqueue(s);
        p.enqueue(s);

        try {
            p.play();
            p.play();
            p.play();
        } catch (EmptyPlaylistException e) {
            Assertions.fail("Should not have thrown an Exception, but did!");
        }

    }

}
