package com.nasa.domain;

import com.nasa.app.runtime.exceptions.BoardSizeException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarsSurfaceTest {

    @Test
    public void createMapWithTwoDimensionSuccessfully() {
        int xDimension = 10;
        int yDimension = 10;

        MarsSurface marsSurface = new MarsSurface(xDimension, yDimension);
        assertNotNull(marsSurface);
    }

    @Test(expected = BoardSizeException.class)
    public void createMapWithNoDimensionError() {
        new MarsSurface(0, 0);
    }

    @Test
    public void moveMarsRoverForwardSuccessfully() {
        MarsRover marsRover = new MarsRover(Direction.N, new Coordinates(1, 2));
        MarsRover marsRover2 = new MarsRover(Direction.S, new Coordinates(1, 2));
        MarsRover marsRover3 = new MarsRover(Direction.E, new Coordinates(1, 2));
        MarsRover marsRover4 = new MarsRover(Direction.W, new Coordinates(1, 2));

        MarsSurface marsSurface = new MarsSurface(4, 4);

        assertEquals(getPosition(1, 3, Direction.N), marsSurface.move(marsRover, Command.F));
        assertEquals(getPosition(1, 1, Direction.S), marsSurface.move(marsRover2, Command.F));
        assertEquals(getPosition(2, 2, Direction.E), marsSurface.move(marsRover3, Command.F));
        assertEquals(getPosition(0, 2, Direction.W), marsSurface.move(marsRover4, Command.F));
    }

    @Test
    public void moveMarsRoverBackwardSuccessfully() {
        MarsRover marsRover = new MarsRover(Direction.N, new Coordinates(1, 2));
        MarsRover marsRover2 = new MarsRover(Direction.S, new Coordinates(1, 2));
        MarsRover marsRover3 = new MarsRover(Direction.E, new Coordinates(1, 2));
        MarsRover marsRover4 = new MarsRover(Direction.W, new Coordinates(1, 2));

        MarsSurface marsSurface = new MarsSurface(4, 4);

        assertEquals(getPosition(1, 1, Direction.N), marsSurface.move(marsRover, Command.B));
        assertEquals(getPosition(1, 3, Direction.S), marsSurface.move(marsRover2, Command.B));
        assertEquals(getPosition(0, 2, Direction.E), marsSurface.move(marsRover3, Command.B));
        assertEquals(getPosition(2, 2, Direction.W), marsSurface.move(marsRover4, Command.B));
    }

    @Test
    public void moveMarsRoverLeftSuccessfully() {
        MarsRover marsRover = new MarsRover(Direction.N, new Coordinates(1, 2));
        MarsRover marsRover2 = new MarsRover(Direction.S, new Coordinates(1, 2));
        MarsRover marsRover3 = new MarsRover(Direction.E, new Coordinates(1, 2));
        MarsRover marsRover4 = new MarsRover(Direction.W, new Coordinates(1, 2));

        MarsSurface marsSurface = new MarsSurface(4, 4);

        assertEquals(getPosition(1, 2, Direction.W), marsSurface.move(marsRover, Command.L));
        assertEquals(getPosition(1, 2, Direction.E), marsSurface.move(marsRover2, Command.L));
        assertEquals(getPosition(1, 2, Direction.N), marsSurface.move(marsRover3, Command.L));
        assertEquals(getPosition(1, 2, Direction.S), marsSurface.move(marsRover4, Command.L));
    }

    @Test
    public void moveMarsRoverRightSuccessfully() {
        MarsRover marsRover = new MarsRover(Direction.N, new Coordinates(1, 2));
        MarsRover marsRover2 = new MarsRover(Direction.S, new Coordinates(1, 2));
        MarsRover marsRover3 = new MarsRover(Direction.E, new Coordinates(1, 2));
        MarsRover marsRover4 = new MarsRover(Direction.W, new Coordinates(1, 2));

        MarsSurface marsSurface = new MarsSurface(4, 4);

        assertEquals(getPosition(1, 2, Direction.E), marsSurface.move(marsRover, Command.R));
        assertEquals(getPosition(1, 2, Direction.W), marsSurface.move(marsRover2, Command.R));
        assertEquals(getPosition(1, 2, Direction.S), marsSurface.move(marsRover3, Command.R));
        assertEquals(getPosition(1, 2, Direction.N), marsSurface.move(marsRover4, Command.R));
    }

    private Position getPosition(int coordinateX, int coordinateY, Direction direction) {
        return Position.PositionBuilder.aPosition()
                .withDirection(direction)
                .withCoordinates(new Coordinates(coordinateX, coordinateY))
                .build();
    }

    @Test
    public void addObstaclesInSurface() {
        List<Coordinates> obstacles = Arrays.asList(
                new Coordinates(1, 2),
                new Coordinates(2, 3),
                new Coordinates(6, 7),
                new Coordinates(1, 10));
        MarsSurface marsSurface = new MarsSurface(4, 4, obstacles);

        List<Coordinates> expectedObstacles = Arrays.asList(
                new Coordinates(1, 2),
                new Coordinates(2, 3),
                new Coordinates(1, 2),
                new Coordinates(1, 5));

        assertEquals(expectedObstacles, marsSurface.getObstacles());
    }
}
