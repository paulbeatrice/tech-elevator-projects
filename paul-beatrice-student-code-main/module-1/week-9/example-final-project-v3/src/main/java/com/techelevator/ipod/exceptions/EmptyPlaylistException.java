package com.techelevator.ipod.exceptions;

public class EmptyPlaylistException extends Exception {

    public EmptyPlaylistException() {
        super("Cannot play an empty playlist!");
    }

    public EmptyPlaylistException(String message) {
        super(message);
    }

}
