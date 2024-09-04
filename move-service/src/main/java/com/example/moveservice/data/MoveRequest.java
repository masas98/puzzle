package com.example.moveservice.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoveRequest {
  private int tileNumber;
  private MoveDirection moveDirection;

}
