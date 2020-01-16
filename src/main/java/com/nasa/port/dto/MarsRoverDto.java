package com.nasa.port.dto;

public class MarsRoverDto {

    private String direction;
    private int coordinateX;
    private int coordinateY;

    public MarsRoverDto() {
    }

    public MarsRoverDto(String direction, int coordinateX, int coordinateY) {
        this.direction = direction;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String getDirection() {
        return direction;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return String.format("Rover is at x:%d y:%d facing:%s", coordinateX, coordinateY, direction.toLowerCase());
    }
}
