package com.nasa.port.adapter;

import com.nasa.domain.MarsRover;
import com.nasa.domain.MarsSurface;
import com.nasa.port.dto.MarsRoverDto;
import com.nasa.port.dto.MarsSurfaceDto;
import com.nasa.port.mapper.MarsRoverMapper;
import com.nasa.port.mapper.MarsSurfaceMapper;
import com.nasa.service.MarsRoverService;
import org.mapstruct.factory.Mappers;

public class InputAdapter {

    private final MarsRoverMapper marsRoverMapper = Mappers.getMapper(MarsRoverMapper.class);
    private final MarsSurfaceMapper marsSurfaceDtoToMarsRover = Mappers.getMapper(MarsSurfaceMapper.class);
    private final MarsRoverService marsRoverService = new MarsRoverService();

    private MarsSurface marsSurface;
    private MarsRover marsRover;

    public InputAdapter(MarsSurfaceDto marsSurfaceDto, MarsRoverDto marsRoverDto) {
        this.marsRover = marsRoverMapper.marsRoverDtoToMarsRover(marsRoverDto);
        this.marsSurface = marsSurfaceDtoToMarsRover.marsSurfaceDtoToMarsSurface(marsSurfaceDto);
    }

    public MarsRoverDto moveMarsRover(String command) {
        marsRover = marsRoverService.moveMarsRover(marsSurface, marsRover, command);
        return marsRoverMapper.marsRoverToMarsRoverDto(marsRover);
    }
}
