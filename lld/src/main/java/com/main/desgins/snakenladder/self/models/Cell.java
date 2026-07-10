package com.main.desgins.snakenladder.self.models;


import lombok.Data;

@Data
public class Cell {
    int row;
    int col;
    boolean hasObstacle;
    Obstacle obstacle;

    public Cell(int row, int col, boolean hasObstacle, Obstacle obstacle) {
        this.row = row;
        this.col = col;
        this.hasObstacle = hasObstacle;
        if (hasObstacle) {
            this.obstacle = obstacle;
        }
    }
}
