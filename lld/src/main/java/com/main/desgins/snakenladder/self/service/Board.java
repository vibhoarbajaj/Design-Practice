package com.main.desgins.snakenladder.self.service;

import com.main.desgins.snakenladder.self.models.Cell;
import com.main.desgins.snakenladder.self.models.Obstacle;

import java.util.List;

public class Board {
    int size;
    Cell[][] cells;
    public Board(int size, List<Obstacle> obstacles) {
        this.size = size;
        this.cells = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for (Obstacle obstacle : obstacles) {
                    if (obstacle.getRowStart() == i && obstacle.getColStart() == j) {
                        cells[i][j] = new Cell(obstacle.getRowStart(), obstacle.getColStart(), true, obstacle);
                    } else {
                        cells[i][j] = new Cell(i, j, false, null);
                    }
                }
            }
        }
    }
}
