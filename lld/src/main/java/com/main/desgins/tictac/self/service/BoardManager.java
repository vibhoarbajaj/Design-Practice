package com.main.desgins.tictac.self.service;

import com.main.desgins.tictac.self.entity.Board;
import com.main.desgins.tictac.self.entity.Player;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BoardManager {
    private final List<Player> playerList;
    private final Board board;

    public boolean playGame(String turn, int x, int y) {
        for (Player player : playerList) {
            if (player.isTurn()) {
                ArrayList<ArrayList<String>> grid = board.getBoardList();
                if(!putTurn(x, y, turn, grid)){
                    return false;
                }
                if (checkIfWon(grid, turn)) {
                    System.out.println("Player " + player.getName() + " won!");
                    return false;
                }
                player.releaseTurn();
            }
        }
        return true;
    }

    private boolean checkIfWon(ArrayList<ArrayList<String>> grid, String turn) {

        for (int i = 0; i < grid.size(); i++) {
            boolean isWon = true;
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (!grid.get(i).get(j).equals(turn)) {
                    isWon = false;
                }
            }
            if (isWon) {
                return true;
            }
        }

        for (int i = 0; i < grid.get(0).size(); i++) {
            boolean isWon = true;
            for (int j = 0; j < grid.size(); j++) {
                if (!grid.get(j).get(i).equals(turn)) {
                    isWon = false;
                }
            }
            if (isWon) {
                return true;
            }
        }

        int i = 0, j = 0;
        boolean isWon = true;
        while (i < grid.size() && j < grid.get(i).size()) {
            if (!grid.get(i).get(j).equals(turn)) {
                isWon = false;
            } else {
                i++;
                j++;
            }
        }
        if(isWon){
            return true;
        }
        isWon = true;
        i = grid.size() - 1;
        j = grid.size() - 1;
        while (i >= 0 && j >= 0) {
            if (!grid.get(i).get(j).equals(turn)) {
                isWon = false;
            } else {
                i--;
                j--;
            }
        }
        if(isWon) {
            return true;
        }
        return false;
    }

    private boolean putTurn(int x, int y, String turn, ArrayList<ArrayList<String>> grid) {
        if (grid.get(x).get(y).equals("-")) {
            grid.get(x).set(y, turn);
        } else {
            if (!checkIfComplete(grid)) {
                System.out.println("match drawn cant play more turns");
                return false;
            }
        }
        return true;
    }

    private boolean checkIfComplete(ArrayList<ArrayList<String>> grid) {
        for (ArrayList<String> strings : grid) {
            for (String string : strings) {
                if (string.equals("-")) {
                    return true;
                }
            }
        }
        return false;
    }
}
