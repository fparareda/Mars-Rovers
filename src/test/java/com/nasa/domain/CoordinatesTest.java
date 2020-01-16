package com.nasa.domain;

import com.nasa.app.runtime.exceptions.CoordinatesException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CoordinatesTest {

    @Test
    public void createCoordinatesFromTwoPointsSuccessfully() {
        int x = 1;
        int y = 3;

        Coordinates coordinates = new Coordinates(x, y);
        assertNotNull(coordinates);
        assertEquals(x, coordinates.getX());
        assertEquals(y, coordinates.getY());
    }

    @Test(expected = CoordinatesException.class)
    public void createCoordinatesFromNegativePointsWithException() {
        new Coordinates(-1, -5);
    }

}
