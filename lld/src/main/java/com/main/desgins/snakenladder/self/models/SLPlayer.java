package com.main.desgins.snakenladder.self.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SLPlayer {
    String name;
    int numberOfDice;
    int row;
    int col;

   public int getRand() {
        return (int) Math.ceil(Math.random() * 6);
    }
}
