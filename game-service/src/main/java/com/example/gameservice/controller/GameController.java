package com.example.gameservice.controller;

import com.example.gameservice.client.PlayerServiceClient;
import com.example.gameservice.data.Game;
import com.example.gameservice.data.MoveRequest;
import com.example.gameservice.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;
  private final PlayerServiceClient playerServiceClient;

  @PostMapping("/create")
  public Game createGame() {
    return gameService.createGame();
  }

  @GetMapping("/get-game/{gameID}")
  public Game getGame(@PathVariable String gameID) {
    return gameService.getGame(gameID);
  }

  @PostMapping("/move-tile/{gameID}/player/{playerId}")
  public ResponseEntity<Game> moveTile(@PathVariable String playerId, @PathVariable String gameID,
      @RequestBody MoveRequest moveRequest) {
    return gameService.updateGame(playerId, gameID, moveRequest);
  }

  @GetMapping("/player-exists/{playerId}")
  public ResponseEntity<Boolean> playerExists(@PathVariable String playerId) {
    return ResponseEntity.ok(playerServiceClient.playerExists(playerId));
  }

}
