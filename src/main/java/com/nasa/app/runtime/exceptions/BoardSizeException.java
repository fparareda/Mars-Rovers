package com.nasa.app.runtime.exceptions;

public class BoardSizeException extends RuntimeException {

    public BoardSizeException() {
        super("The size of the board has to be greater than 0 in both sides");
    }

}
