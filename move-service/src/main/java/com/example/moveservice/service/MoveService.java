package com.example.moveservice.service;

import com.example.moveservice.client.GameServiceClient;
import com.example.moveservice.data.Game;
import com.example.moveservice.data.MoveDirection;
import com.example.moveservice.data.MoveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoveService {
  private final GameServiceClient gameServiceClient;

  public Game makeMove(String gameId, MoveRequest moveRequest) {
    int tileNumber = moveRequest.getTileNumber();
    MoveDirection moveDirection = moveRequest.getMoveDirection();

    Game game = gameServiceClient.getGame(gameId);
    int movableTile=game.findTile(tileNumber);

    switch (moveDirection) {
      case UP:{
        game.moveUp(movableTile);
      }
      break;
      case DOWN:{
        game.moveDown(movableTile);
      }
      break;
      case LEFT:{
        game.moveLeft(movableTile);

      }
      break;
      case RIGHT:{
        game.moveRight(movableTile);
      }
    }

    return game;
  }
}
