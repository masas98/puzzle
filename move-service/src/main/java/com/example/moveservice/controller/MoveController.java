package com.example.moveservice.controller;

import com.example.moveservice.data.Game;
import com.example.moveservice.data.MoveRequest;
import com.example.moveservice.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/move")
@RequiredArgsConstructor
public class MoveController {
  private final MoveService moveService;

  @PostMapping("/move-tile/{gameId}")
  public Game makeMove(@PathVariable String gameId, @RequestBody MoveRequest moveRequest) {
    return moveService.makeMove(gameId, moveRequest);
  }

}
