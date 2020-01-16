# MY SOLUTION

## Architecture
I decided to create a layered structured based in DDD. In this case I have created:
- Domain
- Service in order to do the action specified 
- Ports to get access into the service to treat and do the logic in the application. I have used adapters in order to separate the logic model from the data transfer objects

## Frameworks

### Fwk Application
The unique framework that I used is mapstruct in order to convert from dto to domain

### Fwk Testing
The frameworks used for testing are:
- Cucumber to do the functional tests
- JUnit to do the unit testing

## Testing
I have decided to use TDD to be sure the velocity and the testability of the code in every moment.
I have separated the 2 different functional requirements: 
- the first one (move the mars over the Mars surface)
- the second one (add obstacles into the Mars surface) 

## Things to consider
- I have implemented the InputAdapter in order to separate the transformation from the service and the runtime. In other kind of applications (like an API), it would be inside the Controller Api port.
- The solution can be a little bit complex architectural speaking, but it is flexible enough to modify and extend the functionality easily
- In every branch created (previous merge it into master), I did squash and merge so, maybe is quite difficult to see the boy-scouting on the code
