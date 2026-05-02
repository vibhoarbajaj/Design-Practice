package com.main.desgins.tictac.course;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private final String name;
    private final PlayingPiece playingPiece;
}
