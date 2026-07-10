package com.main.desgins.snakenladder.self.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Obstacle {
    int rowStart;
    int colStart;
    int rowEnd;
    int colEnd;
    ObstacleType type;
}
