# Backend Tech Test

Hello candidate!!

Welcome to Nasa and its backend technical test

## Mars Rover refactoring kata

We need to improve the existent solution that translates commands sent from Earth to instructions that are understood by our Rover in Mars

Currently the code is very complicated and tangled so we want to ask you to invest some time in it

### Functional requirements
```
Given:
 - a map size of two dimensions for Mars
 - the initial starting point and direction of the Rover
 
When:
 - a command is received
   move `forward` or `backward` or rotate `left` or `right` (90 degrees)

Then:
 - move the Rover
   if arrives at one of the edges follow at the other side (Mars is a sphere after all)
```

#### Bonus point

Once ensured the functional requirements have been made, as a bonus point (not necessary but more than welcome), add a new feature:
```
Given:
 - a possible list of obstacles with their exact location
 
When:
 - Rover moves

And:
 - Rover encounters an obstacle

Then:
 - report back the obstacle and keep the position
```


