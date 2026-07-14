package com.main.desgins.snakenladder.course.model;

public class Board {
    Cell[][] cells;
    int size;
    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
    }
}
