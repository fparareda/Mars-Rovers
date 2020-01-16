package com.nasa.port.mapper;

import com.nasa.domain.Coordinates;
import com.nasa.domain.Direction;
import com.nasa.domain.MarsSurface;
import com.nasa.port.dto.MarsObstacleDto;
import com.nasa.port.dto.MarsRoverDto;
import com.nasa.port.dto.MarsSurfaceDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface MappingFunctions {

    static Coordinates marsRoverCoordinates(MarsRoverDto marsRoverDto) {
        return new Coordinates(marsRoverDto.getCoordinateX(), marsRoverDto.getCoordinateY());
    }

    static Direction marsRoverDirection(MarsRoverDto marsRoverDto) {
        return Direction.lookup(marsRoverDto.getDirection());
    }

    static Coordinates surfaceCoordinates(MarsSurfaceDto marsSurfaceDto) {
        return new Coordinates(marsSurfaceDto.getSizeX(), marsSurfaceDto.getSizeY());
    }

    static Coordinates defaultCoordinates() {
        return new Coordinates(0, 0);
    }

    static List<MarsObstacleDto> transformObstacles(MarsSurface marsSurface) {
        if (marsSurface.getObstacles() == null || marsSurface.getObstacles().isEmpty()) {
            return new ArrayList<>();
        }
        return marsSurface.getObstacles().stream()
                .map(obstacle -> new MarsObstacleDto(obstacle.getX(), obstacle.getY()))
                .collect(Collectors.toList());
    }

    static List<Coordinates> transformObstaclesDto(MarsSurfaceDto marsSurfaceDto) {
        if (marsSurfaceDto.getObstacles() == null || marsSurfaceDto.getObstacles().isEmpty()) {
            return new ArrayList<>();
        }
        return marsSurfaceDto.getObstacles().stream()
                .map(obstacle -> new Coordinates(obstacle.getCoordinateX(), obstacle.getCoordinateY()))
                .collect(Collectors.toList());
    }
}
