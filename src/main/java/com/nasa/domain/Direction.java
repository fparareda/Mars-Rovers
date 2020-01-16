
package com.nasa.domain;

import com.nasa.app.runtime.exceptions.DirectionException;

public enum Direction {

    N(0, 1) {
        @Override
        public Direction turnLeft() {
            return W;
        }

        @Override
        public Direction turnRight() {
            return E;
        }
    },

    S(0, -1) {
        @Override
        public Direction turnRight() {
            return W;
        }

        @Override
        public Direction turnLeft() {
            return E;
        }
    },

    E(1, 0) {
        @Override
        public Direction turnRight() {
            return S;
        }

        @Override
        public Direction turnLeft() {
            return N;
        }
    },

    W(-1, 0) {
        @Override
        public Direction turnRight() {
            return N;
        }

        @Override
        public Direction turnLeft() {
            return S;
        }
    };

    private final int stepOnXAxis;
    private final int stepOnYAxis;

    Direction(final int stepOnXAxis, final int stepOnYAxis) {
        this.stepOnXAxis = stepOnXAxis;
        this.stepOnYAxis = stepOnYAxis;
    }

    public abstract Direction turnRight();

    public abstract Direction turnLeft();

    public static Direction lookup(String directionStr) {
        try {
            return Direction.valueOf(directionStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DirectionException(directionStr);
        }
    }

    public int getStepOnXAxis() {
        return stepOnXAxis;
    }

    public int getStepOnYAxis() {
        return stepOnYAxis;
    }
}
