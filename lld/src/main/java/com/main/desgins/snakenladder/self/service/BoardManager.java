package com.main.desgins.snakenladder.self.service;

import com.main.desgins.snakenladder.self.models.Dice;
import com.main.desgins.snakenladder.self.models.Obstacle;
import com.main.desgins.snakenladder.self.models.SLPlayer;

import java.util.List;

public class BoardManager {

    private final List<SLPlayer> players;
    private final List<Dice> dices;
    private final Board board;

    public BoardManager(List<SLPlayer> players, List<Dice> dices, int size,List<Obstacle> obstacle) {
        this.players = players;
        this.dices = dices;
        this.board = new Board(size,obstacle);
    }

    public SLPlayer playGame() {
        return null;
    }
}
