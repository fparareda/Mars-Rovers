package com.nasa.stepdefs;

import com.nasa.port.dto.MarsObstacleDto;
import cucumber.api.Transformer;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObstaclesListTransformer extends Transformer<List<MarsObstacleDto>> {

    @Override
    public List<MarsObstacleDto> transform(String value) {
        Type listType = new TypeToken<ArrayList<MarsObstacleDto>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
}