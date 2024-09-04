package com.example.gameservice;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import com.example.gameservice.client.MoveServiceClient;
import com.example.gameservice.client.PlayerServiceClient;
import com.example.gameservice.data.Game;
import com.example.gameservice.data.MoveDirection;
import com.example.gameservice.data.MoveRequest;
import com.example.gameservice.service.GameService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class GameServiceApplicationTests {
  @MockBean
  private PlayerServiceClient playerServiceClient;

  @Autowired
  private GameService gameService;

  private final String playerId = UUID.randomUUID().toString();


  @Test
  void testCreateGame() {
    when(playerServiceClient.createPlayer()).thenReturn(playerId);
    Game result = gameService.createGame();

    assertEquals("Player ID should match",playerId, result.getPlayer());
    assertNotNull("Game ID should be created", result.getGameId());
  }


  @Test
  void testUpdateGameUnauthorized() {
    String unauthorizedPlayerId = UUID.randomUUID().toString();
    MoveRequest moveRequest = new MoveRequest();
    moveRequest.setTileNumber(1);
    moveRequest.setMoveDirection(MoveDirection.UP);
    when(playerServiceClient.createPlayer()).thenReturn(playerId);
    Game game = gameService.createGame();

    ResponseEntity<Game> response = gameService.updateGame(unauthorizedPlayerId, game.getGameId(), moveRequest);
    assertEquals("Response should be 403 Forbidden", ResponseEntity.status(403).build(), response);
  }

}
