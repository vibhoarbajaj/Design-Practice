package com.main.desgins.tictac.self;

import com.main.desgins.tictac.self.entity.Board;
import com.main.desgins.tictac.self.entity.Player;
import com.main.desgins.tictac.self.service.BoardManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("player1",true);
        Player player2 = new Player("player2",false);
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        Board board = new Board(3,3);
        BoardManager boardManager = new BoardManager(players,board);
        while(true){
            boardManager.playGame("o", 0,0);
        }

    }
}
