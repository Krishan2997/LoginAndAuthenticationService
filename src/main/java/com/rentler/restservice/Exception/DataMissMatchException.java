package com.rentler.restservice.Exception;

public class DataMissMatchException extends ResourceNotFoundException{

    public DataMissMatchException(String message) {
        super(message);
    }

    public DataMissMatchException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
