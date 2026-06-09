package com.main.desgins.elevator.strategy;

import com.main.desgins.elevator.ElevatorManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InternalButton {

    private final ElevatorManager manager;
    private final InternalDispatcher internalDispatcher;

    public void pressButton(int floor) {
        internalDispatcher.submitInternalRequest(floor, manager);
    }
}
