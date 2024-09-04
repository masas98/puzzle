package com.example.playerservice.controller;

import com.example.playerservice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/player")
@RequiredArgsConstructor
public class PlayerController {
  private final PlayerService playerService;

  @PostMapping("/create")
  public ResponseEntity<String> createPlayer() {
    String playerId = playerService.createPlayer();
    return ResponseEntity.ok(playerId);
  }

  @GetMapping("/player-exists/{playerId}")
  public ResponseEntity<Boolean> playerExists(@PathVariable String playerId) {
    return ResponseEntity.ok(playerService.playerExists(playerId));
  }

}
