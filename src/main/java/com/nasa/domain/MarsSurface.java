package com.nasa.domain;

import com.nasa.app.runtime.exceptions.BoardSizeException;
import com.nasa.app.runtime.exceptions.ObstacleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MarsSurface {
    private Coordinates coordinatesRightTop;
    private Coordinates coordinatesLeftBottom;
    private List<Coordinates> obstacles;

    public MarsSurface() {
    }

    public MarsSurface(final int coordinateTopRightX, final int coordinateTopRightY, final List<Coordinates> obstacles) {
        this(coordinateTopRightX, coordinateTopRightY);
        this.obstacles = recoordinateObstaclesInSurface(obstacles);
    }

    public MarsSurface(final int coordinateTopRightX, final int coordinateTopRightY) {
        if (coordinateTopRightX > 0 && coordinateTopRightY > 0) {
            this.coordinatesLeftBottom = new Coordinates(0, 0);
            this.coordinatesRightTop = new Coordinates(coordinateTopRightX, coordinateTopRightY);
            this.obstacles = new ArrayList<>();
        } else {
            throw new BoardSizeException();
        }
    }

    public Coordinates getCoordinatesRightTop() {
        return coordinatesRightTop;
    }

    public Coordinates getCoordinatesLeftBottom() {
        return coordinatesLeftBottom;
    }

    public List<Coordinates> getObstacles() {
        return obstacles;
    }

    public void setCoordinatesRightTop(Coordinates coordinatesRightTop) {
        this.coordinatesRightTop = coordinatesRightTop;
    }

    public void setCoordinatesLeftBottom(Coordinates coordinatesLeftBottom) {
        this.coordinatesLeftBottom = coordinatesLeftBottom;
    }

    public void setObstacles(List<Coordinates> obstacles) {
        this.obstacles = obstacles;
    }

    private List<Coordinates> recoordinateObstaclesInSurface(List<Coordinates> obstacles) {
        return obstacles.stream()
                .map(obstacle -> getCoordinatesInSurface(obstacle.getX(), obstacle.getY()))
                .collect(Collectors.toList());
    }

    private Coordinates getCoordinatesInSurface(int coordinateX, int coordinateY) {
        if (this.coordinatesRightTop.getX() < coordinateX) {
            coordinateX = coordinateX - this.coordinatesRightTop.getX() - 1;
        }
        if (this.coordinatesRightTop.getY() < coordinateY) {
            coordinateY = coordinateY - this.coordinatesRightTop.getY() - 1;
        }
        return new Coordinates(coordinateX, coordinateY);
    }

    public Position move(MarsRover marsRover, Command command) {
        Coordinates currentCoordinates = marsRover.getCurrentCoordinates();
        Direction currentDirection = marsRover.getCurrentDirection();
        switch (command) {
            case F:
                currentCoordinates = getCoordinatesInSurface(
                        currentCoordinates.getX() + currentDirection.getStepOnXAxis(),
                        currentCoordinates.getY() + currentDirection.getStepOnYAxis());
                break;

            case B:
                currentCoordinates = getCoordinatesInSurface(
                        currentCoordinates.getX() - currentDirection.getStepOnXAxis(),
                        currentCoordinates.getY() - currentDirection.getStepOnYAxis());
                break;

            case L:
                currentDirection = currentDirection.turnLeft();
                break;

            case R:
                currentDirection = currentDirection.turnRight();
                break;
        }

        if (obstacles.contains(currentCoordinates)) {
            throw new ObstacleException(currentCoordinates, command.name());
        }

        return Position.PositionBuilder.aPosition()
                .withCoordinates(currentCoordinates)
                .withDirection(currentDirection)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsSurface that = (MarsSurface) o;
        return Objects.equals(coordinatesRightTop, that.coordinatesRightTop) &&
                Objects.equals(coordinatesLeftBottom, that.coordinatesLeftBottom);
    }
}
