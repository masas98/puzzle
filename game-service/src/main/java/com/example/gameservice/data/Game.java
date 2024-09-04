package com.example.gameservice.data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
  private String gameId;
  private int[][] board;
  private String player;
  private boolean isCompleted;

  public Game(String gameId, String player) {
    this.gameId = gameId;
    this.player = player;
    this.board = initializeBoard();
    this.isCompleted = false;
  }

  private int[][] initializeBoard() {
    int[][] board = new int[4][4];
    List<Integer> numbers = IntStream.range(0, 16).boxed().collect(Collectors.toList());
    Collections.shuffle(numbers);
    for (int i = 0; i < 16; i++) {
      board[i / 4][i % 4] = numbers.get(i);
    }
    return board;
  }
}
