package com.nasa.app.runtime.exceptions;

public class CoordinatesException extends RuntimeException {

    public CoordinatesException() {
        super("The coordinates can not be negative or empty");
    }

}
