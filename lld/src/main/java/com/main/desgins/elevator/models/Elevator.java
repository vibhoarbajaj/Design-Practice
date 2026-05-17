package com.main.desgins.elevator.models;

import lombok.Data;

import java.util.PriorityQueue;

@Data
public class Elevator {
    public Floor currentFloor;
    // because we want that if the next floor is once set no floor in between can add itself in the queue
    public Floor nextStoppage;

    public ElevatorDirection direction;
    // add a bucket
    public PriorityQueue<Elevator> upMinQueue;
    public PriorityQueue<Elevator> downMaxQueue;
}
