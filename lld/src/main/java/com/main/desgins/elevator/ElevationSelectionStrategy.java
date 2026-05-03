package com.main.desgins.elevator;

import com.main.desgins.elevator.models.ElevatorDirection;

import java.util.List;

public interface ElevationSelectionStrategy {
    ElevatorManager selectElevator(List<ElevatorManager> managers, int requestFloor, ElevatorDirection elevatorDirection);
}
