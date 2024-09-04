package com.example.moveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoveServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MoveServiceApplication.class, args);
  }

}
