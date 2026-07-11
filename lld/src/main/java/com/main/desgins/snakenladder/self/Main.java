package com.main.desgins.snakenladder.self;

import com.main.desgins.snakenladder.self.models.Obstacle;
import com.main.desgins.snakenladder.self.models.ObstacleType;
import com.main.desgins.snakenladder.self.models.SLPlayer;
import com.main.desgins.snakenladder.self.service.BoardManager;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        SLPlayer player1 = new SLPlayer("player1", 2, 0, 0);
        SLPlayer player2 = new SLPlayer("player2", 2, 0, 0);
        Deque<SLPlayer> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        Obstacle obstacle1 = new Obstacle(1, 9, 9, 1, ObstacleType.LADDER);
        Obstacle obstacle2 = new Obstacle(2, 3, 1, 1, ObstacleType.SNAKE);
        List<Obstacle> obstacles = new LinkedList<>();
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        BoardManager boardManager = new BoardManager(players, size, obstacles);
        System.out.println(boardManager.playGame() +"winner");

    }
}
