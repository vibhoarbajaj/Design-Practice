package com.main.desgins.tictac.course;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BoardManager {

    Deque<Player> players;
    Board board;

    public void initializeGame(int size) {

        this.players = new LinkedList<>();
        PlayingPiece crossPiece = new PlayingPieceX(PieceType.X);
        PlayingPiece circlePiece = new PlayingPieceO(PieceType.O);

        Player player1 = new Player("p1", crossPiece);
        Player player2 = new Player("p2", circlePiece);

        players.add(player1);
        players.add(player2);

        this.board = new Board(size);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {

            Player currentPlayer = players.removeFirst();
            board.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = board.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }


            System.out.println("Player " + currentPlayer.getName() + " is playing Please enter [row,col]");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean isValidMove = board.addPiece(row, col, currentPlayer.getPlayingPiece());
            if (!isValidMove) {
                System.out.println("Invalid move.");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean isWinner = checkForWinner(row, col, currentPlayer.getPlayingPiece().pieceType);
            if (isWinner) {
                return currentPlayer.getName();
            }
        }
        return "Tie";
    }

    private boolean checkForWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagnolMatch = true;
        boolean antiDiagnolMatch = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getPiece(row, i) == null || board.getPiece(row, i).pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getPiece(i, col) == null || board.getPiece(i, col).pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }
        for (int i = 0, j = 0; j < board.getSize() && i < board.getSize(); i++, j++) {
            if (board.getPiece(i, j) == null || board.getPiece(i, j).pieceType != pieceType) {
                diagnolMatch = false;
                break;
            }
        }
        for (int i = board.getSize() - 1, j = board.getSize() - 1; j >= 0 && i >= 0; i--, j--) {
            if (board.getPiece(i, j) == null || board.getPiece(i, j).pieceType != pieceType) {
                antiDiagnolMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagnolMatch || antiDiagnolMatch;
    }

    public void endGame() {
    }
}
