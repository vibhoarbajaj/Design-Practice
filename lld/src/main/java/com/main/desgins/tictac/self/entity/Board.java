package com.main.desgins.tictac.self.entity;

import lombok.Getter;

import java.util.ArrayList;


public class Board {
    @Getter
    private final ArrayList<ArrayList<String>> boardList;

    public Board(int x, int y) {// can do better in initializing
        boardList = new ArrayList<>(x);

        for (int i = 0; i < x; i++) {
            ArrayList<String> row = new ArrayList<>(y);
            for (int j = 0; j < y; j++) {
                row.add("-");
            }
            boardList.add(row);
        }
    }
}
