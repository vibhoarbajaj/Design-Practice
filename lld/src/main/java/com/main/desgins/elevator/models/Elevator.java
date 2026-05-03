package com.main.desgins.elevator.models;

import lombok.Data;

@Data
public class Elevator {
    public Floor currentFloor;
    public Floor nextStoppage;
    // add a bucket
}
