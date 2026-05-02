package com.main.desgins.tictac.course;

import lombok.Getter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    @Getter
    private final int size;
    private final PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }


    public boolean addPiece(int r, int c, PlayingPiece piece) {
        if (board[r][c] != null) {
            return false;
        }
        board[r][c] = piece;
        return true;
    }

    public PlayingPiece getPiece(int r, int c) {
        return board[r][c];
    }

    public List<Pair<Integer,Integer>> getFreeCells() {
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] == null) {
                    Pair<Integer, Integer> pair = new ImmutablePair<>(r, c);
                    freeCells.add(pair);
                }
            }
        }
        return freeCells;
    }


    public void printBoard() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if(board[r][c] == null) continue;
                System.out.print(board[r][c].toString());
            }
            System.out.println();
        }
    }
}
