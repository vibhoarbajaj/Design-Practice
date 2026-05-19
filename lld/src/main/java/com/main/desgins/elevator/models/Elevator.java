package com.main.desgins.elevator.models;

import lombok.Data;

@Data
public class Elevator {

    public int id;

    public Floor currentFloor;
    // because we want that if the next floor is once set no floor in between can add itself in the queue
    public Floor nextStoppage;

    public ElevatorDirection direction;

    public Door door;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = new Floor(id, 0);
        this.nextStoppage = new Floor(id,-1);
        door = new Door();
    }
}
