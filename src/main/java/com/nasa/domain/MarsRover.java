package com.nasa.domain;

import java.util.Objects;

public class MarsRover {

    private Position position;

    public MarsRover() {
    }

    public MarsRover(Direction currentDirection, Coordinates currentCoordinates) {
        this.position = Position.PositionBuilder.aPosition()
                .withCoordinates(currentCoordinates)
                .withDirection(currentDirection)
                .build();
    }

    public Direction getCurrentDirection() {
        return position.getDirection();
    }

    public Coordinates getCurrentCoordinates() {
        return position.getCoordinates();
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return Objects.equals(position, marsRover.position);
    }

}
