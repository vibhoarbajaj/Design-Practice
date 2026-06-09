package com.main.desgins.elevator.strategy;

import com.main.desgins.elevator.ElevatorManager;
import com.main.desgins.elevator.models.ElevatorDirection;
import com.main.desgins.elevator.models.ElevatorScheduler;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ExternalDispatcher {

    private final ElevatorScheduler elevatorScheduler;

    public void submitExternalRequest(int floor, ElevatorDirection direction) {
        ElevatorManager manager = elevatorScheduler.assignElevator(floor, direction);
        manager.submitRequest(floor);
    }
}
