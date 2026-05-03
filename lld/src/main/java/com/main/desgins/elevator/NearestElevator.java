package com.main.desgins.elevator;

import com.main.desgins.elevator.models.ElevatorDirection;
import com.main.desgins.elevator.models.Floor;

import java.util.List;

public class NearestElevator implements ElevationSelectionStrategy{
    @Override
    public ElevatorManager selectElevator(List<ElevatorManager> managers, int requestFloor, ElevatorDirection elevatorDirection) {
        ElevatorManager elevatorManager = null;
        int minDistance = Integer.MAX_VALUE;
        for (ElevatorManager manager : managers) {
            int nextFloor = manager.getElevator().nextStoppage.getFloorNumber();

        }
    }
}
