package com.techelevator.ipod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Podcast implements Listenable {
    private String episodeName;
    private String creator;
    private LocalDate releaseDate;
    private String genre;

    public Podcast() { }

    public Podcast(String episodeName, String creator, LocalDate releaseDate, String genre) {
        this.episodeName = episodeName;
        this.creator = creator;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    @Override
    public List<String> getTranscript() {
        // TODO: Make this work
        return new ArrayList<String>();
    }

    @Override
    public String toString() {
        return episodeName + " by " + creator;
    }



    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
