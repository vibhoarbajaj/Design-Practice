package com.main.desgins.tictac.self.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private final String name;
    private boolean isTurn;

    public void releaseTurn(){
        this.isTurn=false;
    }
}
