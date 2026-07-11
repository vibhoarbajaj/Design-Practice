package com.main.desgins.snakenladder.self.service;

import com.main.desgins.snakenladder.self.models.Obstacle;
import com.main.desgins.snakenladder.self.models.SLPlayer;

import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class BoardManager {

    private final Deque<SLPlayer> players;
    private final Board board;

    public BoardManager(Deque<SLPlayer> players, int size, List<Obstacle> obstacle) {
        this.players = players;
        this.board = new Board(size, obstacle);
    }

    public SLPlayer playGame() {
        while (true) {
            SLPlayer player = players.poll();
            int val = 0;
            for (int i = 0; i < Objects.requireNonNull(player).getNumberOfDice(); i++) {
                val += player.getRand();
            }
            boolean isWinner = board.movePlayer(val, player);
            if (isWinner) {
                return player;
            } else {
                players.addLast(player);
            }
        }
    }
}
