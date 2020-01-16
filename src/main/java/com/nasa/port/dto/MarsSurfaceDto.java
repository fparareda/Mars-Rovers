package com.nasa.port.dto;

import java.util.ArrayList;
import java.util.List;

public class MarsSurfaceDto {

    private int sizeX;
    private int sizeY;

    private List<MarsObstacleDto> obstacles;

    public MarsSurfaceDto() {
    }

    public MarsSurfaceDto(int sizeX, int sizeY, List<MarsObstacleDto> obstacles) {
        this(sizeX, sizeY);
        this.obstacles = obstacles;
    }

    public MarsSurfaceDto(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.obstacles = new ArrayList<>();

    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public List<MarsObstacleDto> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<MarsObstacleDto> obstacles) {
        this.obstacles = obstacles;
    }
}
