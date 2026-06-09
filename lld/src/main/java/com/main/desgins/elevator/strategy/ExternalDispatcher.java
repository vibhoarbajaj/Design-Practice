package com.main.desgins.elevator.strategy;

import com.main.desgins.elevator.ElevatorManager;
import com.main.desgins.elevator.models.ElevatorDirection;
import com.main.desgins.elevator.models.ElevatorScheduler;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ExternalDispatcher {

    private final ElevatorScheduler elevatorScheduler;

    public void submitExternalRequest(int floor, ElevatorDirection direction) {
        // lift call , will get the lift and go inside
        ElevatorManager manager = elevatorScheduler.assignElevator(floor, direction);
        // this is the lift submitting the req to go on a certain floor
        manager.submitRequest(floor);
    }
}
