package com.main.desgins.elevator;

import com.main.desgins.elevator.models.ElevatorDirection;

import java.util.List;

public class NearestElevator implements ElevationSelectionStrategy {
    @Override
    public ElevatorManager selectElevator(List<ElevatorManager> managers, int requestFloor, ElevatorDirection elevatorDirection) {
        ElevatorManager elevatorManager = null;
        int minDistance = Integer.MAX_VALUE;

        // Pick the one which is going in the same direction and minimum distance from the destination
        for (ElevatorManager manager : managers) {
            // because we want that if the next floor is once set no floor in between can add itself in the queue
            int nextFloor = manager.getElevator().nextStoppage.getFloorNumber();

            boolean isSameDirectionAndValid = manager.getElevator().getDirection() == elevatorDirection &&
                    ((elevatorDirection == ElevatorDirection.UP && nextFloor<= requestFloor)
                            || (elevatorDirection == ElevatorDirection.DOWN && nextFloor >= requestFloor));

            int dist = Math.abs(nextFloor - requestFloor);
            if(isSameDirectionAndValid && dist < minDistance) {
              minDistance = dist;
              elevatorManager = manager;
            }
        }
        // fallback : if not able to choose pick the idle one
        if(elevatorManager == null) {
            for(ElevatorManager manager : managers) {
                if(manager.getElevator().direction.equals(ElevatorDirection.IDLE)) {
                    elevatorManager = manager;
                    break;
                }
            }
        }

        return elevatorManager;
    }
}
