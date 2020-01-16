package com.nasa.app.runtime.exceptions;

public class CommandException extends RuntimeException {

    public CommandException(String commandStr) {
        super("Invalid value for Command: " + commandStr + ". Should be one of: f = forward, b = backward, l = turn left, r = turn right");
    }

}
