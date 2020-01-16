package com.nasa.mapper;

import com.nasa.domain.MarsSurface;
import com.nasa.port.dto.MarsObstacleDto;
import com.nasa.port.dto.MarsSurfaceDto;
import com.nasa.port.mapper.MarsSurfaceMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MarsSurfaceMapperTest {
    private MarsSurfaceMapper mapper = Mappers.getMapper(MarsSurfaceMapper.class);

    @Test
    public void shouldMapMarsSurfaceToDto() {
        //given
        int sizeSurfaceX = 10;
        int sizeSurfaceY = 10;
        MarsSurface marsSurface = new MarsSurface(sizeSurfaceX, sizeSurfaceY);

        //when
        MarsSurfaceDto marsSurfaceDto = mapper.marsSurfaceToMarsSurfaceDto(marsSurface);

        //then
        assertNotNull(marsSurfaceDto);
        assertEquals(sizeSurfaceX, marsSurfaceDto.getSizeX());
        assertEquals(sizeSurfaceY, marsSurfaceDto.getSizeY());
        assertTrue(marsSurface.getObstacles().isEmpty());
    }

    @Test
    public void shouldMapDtoToMarsSurface() {
        //given
        int sizeSurfaceX = 10;
        int sizeSurfaceY = 10;
        MarsSurfaceDto marsSurfaceDto = new MarsSurfaceDto(sizeSurfaceX, sizeSurfaceY);

        //when
        MarsSurface marsSurface = mapper.marsSurfaceDtoToMarsSurface(marsSurfaceDto);

        //then
        assertNotNull(marsSurface);
        assertEquals(sizeSurfaceX, marsSurface.getCoordinatesRightTop().getX());
        assertEquals(sizeSurfaceY, marsSurface.getCoordinatesRightTop().getY());
        assertTrue(marsSurface.getObstacles().isEmpty());
    }

    @Test
    public void shouldMapDtoToMarsSurfaceWithObstacles() {
        //given
        int sizeSurfaceX = 10;
        int sizeSurfaceY = 10;
        MarsSurfaceDto marsSurfaceDto = new MarsSurfaceDto(
                sizeSurfaceX,
                sizeSurfaceY,
                Arrays.asList(
                        new MarsObstacleDto(2, 2),
                        new MarsObstacleDto(3, 3),
                        new MarsObstacleDto(4, 4)));

        //when
        MarsSurface marsSurface = mapper.marsSurfaceDtoToMarsSurface(marsSurfaceDto);

        //then
        assertNotNull(marsSurface);
        assertEquals(sizeSurfaceX, marsSurface.getCoordinatesRightTop().getX());
        assertEquals(sizeSurfaceY, marsSurface.getCoordinatesRightTop().getY());
        assertFalse(marsSurface.getObstacles().isEmpty());
    }


}
