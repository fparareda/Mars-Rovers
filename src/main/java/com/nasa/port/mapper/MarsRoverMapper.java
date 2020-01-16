package com.nasa.port.mapper;

import com.nasa.domain.MarsRover;
import com.nasa.port.dto.MarsRoverDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(imports = MappingFunctions.class)
public interface MarsRoverMapper {

    MarsRoverMapper INSTANCE = Mappers.getMapper(MarsRoverMapper.class);

    @Mappings({
            @Mapping(target = "coordinateX", source = "position.coordinates.x"),
            @Mapping(target = "coordinateY", source = "position.coordinates.y"),
            @Mapping(target = "direction", expression = "java(marsRover.getPosition().getDirection().toString())")
    })
    MarsRoverDto marsRoverToMarsRoverDto(MarsRover marsRover);


    @Mappings({
            @Mapping(expression = "java(MappingFunctions.marsRoverCoordinates(marsRoverDto))", target = "position.coordinates"),
            @Mapping(expression = "java(MappingFunctions.marsRoverDirection(marsRoverDto))", target = "position.direction")
    })
    MarsRover marsRoverDtoToMarsRover(MarsRoverDto marsRoverDto);
}
