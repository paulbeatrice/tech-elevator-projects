package com.techelevator.ipod.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Song implements Listenable {

    private String title;
    private String artist;
    private LocalDate releaseDate;
    private String genre;


    public Song() { }

    public Song(String title, String artist, LocalDate releaseDate, String genre) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }

    @Override
    public List<String> getTranscript() {
        // TODO: Make this work
        return new ArrayList<String>();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
