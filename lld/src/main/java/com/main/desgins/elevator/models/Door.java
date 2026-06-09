package com.main.desgins.elevator.models;

import lombok.Data;

@Data
public class Door {
    private DoorState doorState;

    public void openDoor(int id) {
        doorState = DoorState.DOOR_OPEN;
        System.out.println("Opening the Elevator door of elevator:" + id);
    }

    public void closeDoor(int id) {
        doorState = DoorState.DOOR_CLOSED;
        System.out.println("Closing the Elevator door of elevator:" + id);
    }
}
