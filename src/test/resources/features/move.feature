Feature: Move Mars Rover into Mars surface

  Scenario Outline:   Create a map size of two dimensions for Mars, put a mars in an initial point with direction and move it using the command's order

    Given a map size of <mapSizeXAxis> <mapSizeYAxis> dimensions for Mars
    And the <xCoordinateStartPoint> <yCoordinateStartPoint> <directionStartPoint> as initial starting point and direction of the Rover
    When a command <command> is received
    Then move the Rober to <xCoordinateEndPoint> <yCoordinateEndPoint> <directionEndPoint>

    Examples:
      | mapSizeXAxis | mapSizeYAxis | xCoordinateStartPoint | yCoordinateStartPoint | directionStartPoint | command | xCoordinateEndPoint | yCoordinateEndPoint | directionEndPoint |
      | 4            | 4            | 1                     | 2                     | N                   | F       | 1                   | 3                   | N                 |
      | 4            | 4            | 1                     | 2                     | N                   | B       | 1                   | 1                   | N                 |
      | 4            | 4            | 1                     | 2                     | N                   | L       | 1                   | 2                   | W                 |
      | 4            | 4            | 1                     | 2                     | N                   | R       | 1                   | 2                   | E                 |

      | 4            | 4            | 1                     | 2                     | S                   | F       | 1                   | 1                   | S                 |
      | 4            | 4            | 1                     | 2                     | S                   | B       | 1                   | 3                   | S                 |
      | 4            | 4            | 1                     | 2                     | S                   | L       | 1                   | 2                   | E                 |
      | 4            | 4            | 1                     | 2                     | S                   | R       | 1                   | 2                   | W                 |

      | 4            | 4            | 1                     | 2                     | E                   | F       | 2                   | 2                   | E                 |
      | 4            | 4            | 1                     | 2                     | E                   | B       | 0                   | 2                   | E                 |
      | 4            | 4            | 1                     | 2                     | E                   | L       | 1                   | 2                   | N                 |
      | 4            | 4            | 1                     | 2                     | E                   | R       | 1                   | 2                   | S                 |

      | 4            | 4            | 1                     | 2                     | W                   | F       | 0                   | 2                   | W                 |
      | 4            | 4            | 1                     | 2                     | W                   | B       | 2                   | 2                   | W                 |
      | 4            | 4            | 1                     | 2                     | W                   | L       | 1                   | 2                   | S                 |
      | 4            | 4            | 1                     | 2                     | W                   | R       | 1                   | 2                   | N                 |

      | 4            | 4            | 4                     | 2                     | E                   | F       | 0                   | 2                   | E                 |
      | 4            | 4            | 2                     | 4                     | N                   | F       | 2                   | 0                   | N                 |


