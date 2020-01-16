package com.nasa.service;

import com.nasa.app.runtime.exceptions.ObstacleException;
import com.nasa.domain.Coordinates;
import com.nasa.domain.Direction;
import com.nasa.domain.MarsRover;
import com.nasa.domain.MarsSurface;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarsRoverServiceTest {

    private MarsRoverService marsRoverService = new MarsRoverService();
    private MarsSurface marsSurface;
    private MarsSurface marsSurfaceWithObstacles;

    @Before
    public void setUp() throws Exception {
        marsSurface = new MarsSurface(4, 4);

        List<Coordinates> obstacles = Arrays.asList(
                new Coordinates(2, 2),
                new Coordinates(3, 3),
                new Coordinates(4, 4));
        marsSurfaceWithObstacles = new MarsSurface(4, 4, obstacles);
    }

    @Test
    public void moveForwardMarsRoverOverTheBoard() {
        String command = "f";
        Direction currentDirection = Direction.N;
        int currentPositionX = 1;
        int currentPositionY = 1;
        MarsRover marsRover = new MarsRover(currentDirection, new Coordinates(currentPositionX, currentPositionY));

        marsRover = marsRoverService.moveMarsRover(marsSurface, marsRover, command);
        assertEquals(currentDirection, marsRover.getCurrentDirection());
        assertEquals(currentPositionX, marsRover.getCurrentCoordinates().getX());
        assertEquals(currentPositionY + 1, marsRover.getCurrentCoordinates().getY());
    }

    @Test
    public void moveBackwardMarsRoverOverTheBoard() {
        String command = "b";
        Direction currentDirection = Direction.N;
        int currentPositionX = 1;
        int currentPositionY = 1;
        MarsRover marsRover = new MarsRover(currentDirection, new Coordinates(currentPositionX, currentPositionY));

        marsRover = marsRoverService.moveMarsRover(marsSurface, marsRover, command);
        assertEquals(currentDirection, marsRover.getCurrentDirection());
        assertEquals(currentPositionX, marsRover.getCurrentCoordinates().getX());
        assertEquals(currentPositionY - 1, marsRover.getCurrentCoordinates().getY());
    }

    @Test(expected = ObstacleException.class)
    public void moveForwardMarsRoverOverTheBoardWithObstacle() {
        String command = "f";
        MarsRover marsRover = new MarsRover(Direction.N, new Coordinates(2, 1));

        marsRoverService.moveMarsRover(marsSurfaceWithObstacles, marsRover, command);
    }

}
