package com.example.moveservice.client;

import com.example.moveservice.data.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "game-service")
public interface GameServiceClient {

  @GetMapping("api/game/get-game/{gameID}")
  Game getGame(@PathVariable("gameID") String gameID);

}


