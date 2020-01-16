package com.nasa.domain;

import com.nasa.app.runtime.exceptions.CoordinatesException;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(final int x, final int y) {
        if (x < 0 || y < 0) {
            throw new CoordinatesException();
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }
}
