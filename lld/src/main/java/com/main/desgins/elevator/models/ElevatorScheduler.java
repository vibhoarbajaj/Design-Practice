package com.main.desgins.elevator.models;

import com.main.desgins.elevator.ElevatorManager;
import com.main.desgins.elevator.strategy.ElevationSelectionStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ElevatorScheduler {

    private final List<ElevatorManager> elevators;
    private final ElevationSelectionStrategy elevationSelectionStrategy;

    public ElevatorManager assignElevator(int floor , ElevatorDirection direction){
        return elevationSelectionStrategy.selectElevator(elevators, floor, direction);
    }
}
