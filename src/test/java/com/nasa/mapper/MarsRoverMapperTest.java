package com.nasa.mapper;

import com.nasa.domain.Coordinates;
import com.nasa.domain.Direction;
import com.nasa.domain.MarsRover;
import com.nasa.port.dto.MarsRoverDto;
import com.nasa.port.mapper.MarsRoverMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarsRoverMapperTest {

    private MarsRoverMapper mapper = Mappers.getMapper(MarsRoverMapper.class);

    @Test
    public void shouldMapMarsRoverToDto() {
        //given
        MarsRover marsRover = new MarsRover(Direction.N, new Coordinates(2, 2));

        //when
        MarsRoverDto marsRoverDto = mapper.marsRoverToMarsRoverDto(marsRover);

        //then
        assertNotNull(marsRoverDto);
        assertEquals("N", marsRoverDto.getDirection());
        assertEquals(2, marsRoverDto.getCoordinateX());
        assertEquals(2, marsRoverDto.getCoordinateX());
    }

    @Test
    public void shouldMapDtoToMarsRover() {
        //given
        MarsRoverDto marsRoverDto = new MarsRoverDto("N", 2, 2);

        //when
        MarsRover marsRover = mapper.marsRoverDtoToMarsRover(marsRoverDto);

        //then
        assertNotNull(marsRoverDto);
        assertEquals("N", marsRoverDto.getDirection());
        assertEquals(2, marsRoverDto.getCoordinateX());
        assertEquals(2, marsRoverDto.getCoordinateX());
    }
}
