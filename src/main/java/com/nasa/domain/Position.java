package com.nasa.domain;

import java.util.Objects;

public class Position {

    private Direction direction;
    private Coordinates coordinates;

    public Direction getDirection() {
        return direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static final class PositionBuilder {
        private Direction direction;
        private Coordinates coordinates;

        private PositionBuilder() {
        }

        public static PositionBuilder aPosition() {
            return new PositionBuilder();
        }

        public PositionBuilder withDirection(Direction direction) {
            this.direction = direction;
            return this;
        }

        public PositionBuilder withCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        Position build() {
            Position position = new Position();
            position.direction = this.direction;
            position.coordinates = this.coordinates;
            return position;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return direction == position.direction &&
                Objects.equals(coordinates, position.coordinates);
    }
}
