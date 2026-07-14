package com.main.desgins.snakenladder.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Cell {
    Jump jump;
    int position;
    boolean hasJump;
}
