package com.example.gameservice.client;

import com.example.gameservice.data.Game;
import com.example.gameservice.data.MoveRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "move-service")
public interface MoveServiceClient {

  @PostMapping("api/move/move-tile/{gameId}")
  Game moveTile(@PathVariable("gameId") String gameId, @RequestBody MoveRequest moveRequest);

}
