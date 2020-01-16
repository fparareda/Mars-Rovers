package com.nasa.app.runtime.exceptions;

import com.nasa.domain.Coordinates;

public class ObstacleException extends RuntimeException {

    public ObstacleException(Coordinates currentCoordinates, String commandStr) {
        super("There is an obstacle in the position (" + currentCoordinates.getX() + "," + currentCoordinates.getY() + ") once I execute the Command: " + commandStr + ". You should consider another command, captain!");
    }

}
