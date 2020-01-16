Feature: Move Mars Rover into Mars surface with obstacles

  Scenario Outline:   Create a map size of two dimensions for Mars, put a mars in an initial point with direction and move it using the command's order

    Given a map size of <mapSizeXAxis> <mapSizeYAxis> dimensions for Mars
    And the <xCoordinateStartPoint> <yCoordinateStartPoint> <directionStartPoint> as initial starting point and direction of the Rover
    And a list of obstacles <listOfObstacles>
    When a command is received and rover encounters an obstacle
    Then report back that the command <command> get back an obstacle

    Examples:
      | mapSizeXAxis | mapSizeYAxis | xCoordinateStartPoint | yCoordinateStartPoint | directionStartPoint | listOfObstacles                                                              | command |
      | 4            | 4            | 1                     | 2                     | N                   | [{"coordinateX": 1, "coordinateY": 3}, {"coordinateX": 2, "coordinateY": 2}] | F       |
      | 4            | 4            | 1                     | 2                     | E                   | [{"coordinateX": 1, "coordinateY": 3}, {"coordinateX": 2, "coordinateY": 2}] | F       |



