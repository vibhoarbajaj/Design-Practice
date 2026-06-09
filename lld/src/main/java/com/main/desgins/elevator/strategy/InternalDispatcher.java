package com.main.desgins.elevator.strategy;

import com.main.desgins.elevator.ElevatorManager;

public class InternalDispatcher {

    public void submitInternalRequest(int floor, ElevatorManager manager) {
        manager.submitRequest(floor);
    }
}
