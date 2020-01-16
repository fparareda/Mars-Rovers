package com.nasa.domain;

import com.nasa.app.runtime.exceptions.CommandException;

public enum Command {
    F,
    B,
    L,
    R;

    public static Command lookup(String commandStr) {
        try {
            return Command.valueOf(commandStr);
        } catch (IllegalArgumentException e) {
            throw new CommandException(commandStr);
        }
    }
}
