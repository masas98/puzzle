package com.example.moveservice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import com.example.moveservice.client.GameServiceClient;
import com.example.moveservice.data.Game;
import com.example.moveservice.data.MoveDirection;
import com.example.moveservice.data.MoveRequest;
import com.example.moveservice.service.MoveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MoveServiceApplicationTests {

  @MockBean
  private GameServiceClient gameServiceClient;
  @Autowired
  private MoveService moveService;

  @Test
  void testMoveTileIntegration() {
    MoveRequest moveRequest = new MoveRequest();
    moveRequest.setTileNumber(1);
    moveRequest.setMoveDirection(MoveDirection.RIGHT);

    Game game = new Game();
    game.setGameId("123");
    game.setPlayer("12345");
    game.setCompleted(false);

    when(gameServiceClient.getGame(game.getGameId())).thenReturn(game);
    Game gameResult = moveService.makeMove(game.getGameId(), moveRequest);

    assertThat(gameResult).isNotNull();
  }

}
