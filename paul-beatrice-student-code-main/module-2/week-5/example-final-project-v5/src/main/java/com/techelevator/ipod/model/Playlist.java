package com.techelevator.ipod.model;

import com.techelevator.ipod.exceptions.EmptyPlaylistException;

import java.util.LinkedList;
import java.util.Queue;

public class Playlist {

    private int playlistId;
    private String name;
    private Queue<Listenable> queue;


    public Playlist() { }
    public Playlist(int playlistId, String name) {
        this.playlistId = playlistId;
        this.name = name;
        this.queue = new LinkedList<>();
    }

    public boolean enqueue(Listenable newListenable) {
        boolean successfullyAdded = queue.offer(newListenable); // enqueues the new song/podcast/audiobook/whatever Listenable object I get
        return successfullyAdded;
    }

    public Listenable play() throws EmptyPlaylistException {

        if (queue == null || queue.isEmpty() /* same as: queue.size() == 0 */) {
            throw new EmptyPlaylistException();
        }

        Listenable nextSong = queue.poll();

        return nextSong;
    }



    public String getName() {
        return name;
    }

    public Queue<Listenable> getQueue() {
        return queue;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
}
