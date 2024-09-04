package com.example.gameservice.service;

import com.example.gameservice.client.MoveServiceClient;
import com.example.gameservice.client.PlayerServiceClient;
import com.example.gameservice.data.Game;
import com.example.gameservice.data.MoveRequest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
  private final Map<String, Game> games = new ConcurrentHashMap<>();
  private final PlayerServiceClient playerServiceClient;
  private final MoveServiceClient moveServiceClient;

  public Game createGame() {
    String playerId = playerServiceClient.createPlayer();
    String gameId = UUID.randomUUID().toString();
    Game game = new Game(gameId, playerId);
    games.put(gameId, game);
    return game;
  }

  public Game getGame(String gameId) {
    return games.get(gameId);
  }

  public ResponseEntity<Game> updateGame(String playerId, String gameId, MoveRequest moveRequest) {
    String playerIdInGame = getGame(gameId).getPlayer();
    if (playerIdInGame.equals(playerId)) {
      Game updatedGameBoard = moveServiceClient.moveTile(gameId, moveRequest);
      games.put(gameId, updatedGameBoard);
      return ResponseEntity.ok(games.get(gameId));
    }
    return ResponseEntity.status(403).build();
  }
}
