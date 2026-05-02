package com.main.desgins.tictac.course;

public class Main {
    public static void main(String[] args) {
        System.out.println("TicTacToe game");
        BoardManager boardManager = new BoardManager();
        boardManager.initializeGame(3);
        System.out.println("Game winner is " + boardManager.startGame());
    }
}
