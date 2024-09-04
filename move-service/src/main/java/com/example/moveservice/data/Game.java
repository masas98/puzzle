package com.example.moveservice.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
  private String gameId;
  private int[][] board;
  private String player;
  private boolean isCompleted;

  public int findTile(int tileNumber) {
    return tileNumber;
  }
  public void moveUp(int tileNumber) {
    //moves tile up
  }
  public void moveDown(int tileNumber) {
    //moves tile down
  }
  public void moveLeft(int tileNumber) {
    //moves tile left
  }
  public void moveRight(int tileNumber) {
    //moves tile right
  }
}
