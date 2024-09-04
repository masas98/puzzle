package com.example.playerservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.playerservice.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerServiceApplicationTests {

  private PlayerService playerService;

  @BeforeEach
  void setUp() {
    playerService = new PlayerService();
  }

  @Test
  void testCreatePlayer() {
    String playerId = playerService.createPlayer();
    assertTrue(playerService.playerExists(playerId), "Player should be created and exist");
  }

  @Test
  void testPlayerExists() {
    String playerId = playerService.createPlayer();
    assertTrue(playerService.playerExists(playerId), "Player should exist");
    assertFalse(playerService.playerExists("non-existing-id"), "Non-existing player should not exist");
  }

}
