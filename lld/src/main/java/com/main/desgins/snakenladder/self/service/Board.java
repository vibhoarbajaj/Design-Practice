package com.main.desgins.snakenladder.self.service;

import com.main.desgins.snakenladder.self.models.Cell;
import com.main.desgins.snakenladder.self.models.Obstacle;
import com.main.desgins.snakenladder.self.models.ObstacleType;
import com.main.desgins.snakenladder.self.models.SLPlayer;

import java.util.List;

public class Board {
    int size;
    Cell[][] cells;

    public Board(int size, List<Obstacle> obstacles) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isFilled = false;
                for (Obstacle obstacle : obstacles) {
                    if (obstacle.getRowStart() == i && obstacle.getColStart() == j && obstacle.getType().equals(ObstacleType.SNAKE)) {
                        cells[i][j] = new Cell(i,j, true, obstacle);
                        isFilled = true;
                        break;
                    }
                    else  if (obstacle.getRowEnd() == i && obstacle.getColEnd() == j && obstacle.getType().equals(ObstacleType.LADDER)) {
                        cells[i][j] = new Cell(i,j, true, obstacle);
                        isFilled = true;
                        break;
                    }
                }
                if (!isFilled) {
                    cells[i][j] = new Cell(i, j, false, null);
                }
            }
        }
    }

    public boolean movePlayer(int val , SLPlayer player) {
        int currentRow = player.getRow();
        int currentColInRow = (currentRow % 2 == 0) ? player.getCol() : size - 1 - player.getCol();
        int currentPos = currentRow * size + currentColInRow;

        int newPos = currentPos + val;
        if (newPos > size * size - 1) {
            return false; // overshoot, stay put
        }

        int newRow = newPos / size;
        int colInRow = newPos % size;
        int newCol = (newRow % 2 == 0) ? colInRow : size - 1 - colInRow;

        Cell cell = cells[newRow][newCol];
        if(cell.isHasObstacle()) {
            Obstacle obstacle = cell.getObstacle();
            if(cell.getObstacle().getType().equals(ObstacleType.SNAKE)){
                newRow = obstacle.getRowEnd(); // this is where the snake will take u down
                newCol = obstacle.getColEnd();
            }
            else{
                newRow = obstacle.getRowStart(); // ladder will take u up , so the start of ladder is higher
                newCol = obstacle.getColStart();
            }
        }
        player.setRow(newRow);
        player.setCol(newCol);
        return newPos == size * size - 1;
    }
}
