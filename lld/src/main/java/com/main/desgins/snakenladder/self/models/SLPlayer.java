package com.main.desgins.snakenladder.self.models;

import lombok.Data;

@Data
public class SLPlayer {
    String name;
    int numberOfDice;
    int row;
    int col;

   public int getRand() {
        return (int) Math.ceil(Math.random() * 6);
    }
}
