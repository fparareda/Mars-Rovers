package com.nasa.service;

import com.nasa.domain.Command;
import com.nasa.domain.MarsRover;
import com.nasa.domain.MarsSurface;
import com.nasa.domain.Position;

public class MarsRoverService {

    public MarsRover moveMarsRover(MarsSurface marsSurface, MarsRover marsRover, String command) {
        Position position = marsSurface.move(marsRover, Command.lookup(command.toUpperCase()));
        marsRover.setPosition(position);
        return marsRover;
    }
}
