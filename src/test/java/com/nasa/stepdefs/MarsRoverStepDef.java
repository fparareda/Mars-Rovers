package com.nasa.stepdefs;


import com.nasa.app.runtime.exceptions.ObstacleException;
import com.nasa.port.adapter.InputAdapter;
import com.nasa.port.dto.MarsObstacleDto;
import com.nasa.port.dto.MarsRoverDto;
import com.nasa.port.dto.MarsSurfaceDto;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MarsRoverStepDef {

    private InputAdapter inputAdapter;
    private MarsSurfaceDto marsSurfaceDto;
    private MarsRoverDto marsRoverDto;

    @Given("^a map size of (\\d+) (\\d+) dimensions for Mars$")
    public void createTheMarsSurface(int mapSizeXAxis, int mapSizeYAxis) {
        marsSurfaceDto = new MarsSurfaceDto(mapSizeXAxis, mapSizeYAxis);
    }

    @And("^the (\\d+) (\\d+) (.+) as initial starting point and direction of the Rover$")
    public void createAMarsRover(int xCoordinateStartPoint, int yCoordinateStartPoint, String directionStartPoint) {
        marsRoverDto = new MarsRoverDto(directionStartPoint, xCoordinateStartPoint, yCoordinateStartPoint);
        inputAdapter = new InputAdapter(marsSurfaceDto, marsRoverDto);
    }

    @And("^a list of obstacles (.*?)$")
    public void listOfObstacles(@Transform(ObstaclesListTransformer.class) List<MarsObstacleDto> obstacles) {
        marsSurfaceDto = new MarsSurfaceDto(marsSurfaceDto.getSizeX(), marsSurfaceDto.getSizeY(), obstacles);
        inputAdapter = new InputAdapter(marsSurfaceDto, marsRoverDto);
    }

    @When("^a command (.+) is received$")
    public void receiveACommand(String command) {
        marsRoverDto = inputAdapter.moveMarsRover(command);
    }

    @When("^a command is received and rover encounters an obstacle$")
    public void commandReceived() {
    }

    @And("^rover encounters an obstacle$")
    public void roverFindAnObstacle() {
    }

    @Then("^move the Rober to (\\d+) (\\d+) (.+)$")
    public void moveMarsRober(int xCoordinateEndPoint, int yCoordinateEndPoint, String directionEndPoint) {
        assertEquals(directionEndPoint, marsRoverDto.getDirection());
        assertEquals(xCoordinateEndPoint, marsRoverDto.getCoordinateX());
        assertEquals(yCoordinateEndPoint, marsRoverDto.getCoordinateY());
    }

    @Then("^report back that the command (.+) get back an obstacle$")
    public void reportAnObstacle(String command) {
        assertThrows(ObstacleException.class, () -> {
            inputAdapter.moveMarsRover(command);
        });
    }

}
