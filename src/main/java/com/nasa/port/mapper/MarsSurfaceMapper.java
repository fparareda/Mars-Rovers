package com.nasa.port.mapper;

import com.nasa.domain.MarsSurface;
import com.nasa.port.dto.MarsSurfaceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(imports = MappingFunctions.class)
public interface MarsSurfaceMapper {

    MarsSurfaceMapper INSTANCE = Mappers.getMapper(MarsSurfaceMapper.class);

    @Mappings({
            @Mapping(target = "sizeX", source = "coordinatesRightTop.x"),
            @Mapping(target = "sizeY", source = "coordinatesRightTop.y"),
            @Mapping(target = "obstacles", expression = "java(MappingFunctions.transformObstacles(marsSurface))"),
    })
    MarsSurfaceDto marsSurfaceToMarsSurfaceDto(MarsSurface marsSurface);

    @Mappings({
            @Mapping(expression = "java(MappingFunctions.transformObstaclesDto(marsSurfaceDto))", target = "obstacles"),
            @Mapping(expression = "java(MappingFunctions.surfaceCoordinates(marsSurfaceDto))", target = "coordinatesRightTop"),
            @Mapping(expression = "java(MappingFunctions.defaultCoordinates())", target = "coordinatesLeftBottom")
    })
    MarsSurface marsSurfaceDtoToMarsSurface(MarsSurfaceDto marsSurfaceDto);
}
