package com.main.desgins.elevator.strategy;

import com.main.desgins.elevator.ElevatorManager;
import com.main.desgins.elevator.models.ElevatorDirection;

import java.util.List;

public class LeastBusyElevator implements ElevationSelectionStrategy {
    @Override
    public ElevatorManager selectElevator(List<ElevatorManager> managers, int requestFloor, ElevatorDirection elevatorDirection) {

        ElevatorManager elevatorManager = null;
        int minLoad = Integer.MAX_VALUE;

        for(ElevatorManager elevatorManagers : managers){
            int load  = elevatorManagers.upMinQueue.size() + elevatorManagers.downMaxQueue.size();
            if(load < minLoad){
                minLoad = load;
                elevatorManager = elevatorManagers;
            }
        }
        return elevatorManager;
    }
}
