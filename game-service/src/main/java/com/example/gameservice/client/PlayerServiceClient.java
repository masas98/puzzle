package com.example.gameservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "player-service")
public interface PlayerServiceClient {

  @GetMapping("api/player/player-exists/{playerId}")
  Boolean playerExists(@PathVariable("playerId") String playerId);

  @PostMapping("api/player/create")
  String createPlayer();

}
