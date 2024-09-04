# Puzzle game using springBoot microservices

## About
The game does not have any logic. Its just creates players and instance of the game, all games are saved in local memory. 
This is just for learning purposes on how to create microservices using springBoot.

## microservices:
* Game-service - handles game-creation, and game-update.
* Move-service - handles puzzle-moves.
* Player-service - handles-player-creation.
* Gateway-service - handles, that all other services could be reached on the same port.
* Name-service - handles the services names, so it will know which service is calling which service.

  
*(Should also create Validation-service or should validate data inside services).* 

## Running on your machine

Configure project language to JAVA 17.
Install all maven dependencies.
Run all 5 services.
You should reach api's on localhost:8080

example: http://localhost:8080/game-service/api/game/create - creates and returns game info.
