package com.nasa.app.runtime.exceptions;

public class DirectionException extends RuntimeException {

    public DirectionException(String directionStr) {
        super("Invalid value for Direction: " + directionStr + ". Should be one of: n = north, e = east, w = west, s = south");
    }

}
