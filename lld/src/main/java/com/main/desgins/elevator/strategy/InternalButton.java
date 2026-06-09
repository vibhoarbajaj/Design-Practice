package com.main.desgins.elevator.strategy;

import com.main.desgins.elevator.ElevatorManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InternalButton {

    private final ElevatorManager manager;

    public void pressButton(int floor) {
        InternalDispatcher.submitInternalRequest(floor, manager);
    }
}
