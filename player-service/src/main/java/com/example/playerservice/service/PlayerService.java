package com.example.playerservice.service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private final Map<String, Boolean> players = new ConcurrentHashMap<>();

  public String createPlayer() {
    String playerId = UUID.randomUUID().toString();
    players.put(playerId, true);
    return playerId;
  }

  public boolean playerExists(String playerId) {
      return players.containsKey(playerId);
  }
}

