package com.techelevator.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(){
        super();
    }
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
