package com.main.desgins.elevator;

import com.main.desgins.elevator.models.Building;
import com.main.desgins.elevator.models.Elevator;
import com.main.desgins.elevator.models.ElevatorScheduler;
import com.main.desgins.elevator.strategy.ExternalDispatcher;
import com.main.desgins.elevator.strategy.InternalButton;
import com.main.desgins.elevator.strategy.NearestElevator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create the elevators and there managers
        Elevator elevator1= new Elevator(1);
        ElevatorManager elevatorManager1 = new ElevatorManager(elevator1);
        Elevator elevator2= new Elevator(2);
        ElevatorManager elevatorManager2 = new ElevatorManager(elevator2);

        // internal buttons
        InternalButton elevator1InternalButton=  new InternalButton(elevatorManager1);
        InternalButton elevator2InternalButton=  new InternalButton(elevatorManager2);


        // sheduler
        ElevatorScheduler elevatorScheduler = new ElevatorScheduler(List.of(elevatorManager1,elevatorManager2),new NearestElevator());

        ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorScheduler);


        // creatuing building and floors

        Building building= new Building(10,externalDispatcher);


        new Thread(elevatorManager1,"manager1").start();
        new Thread(elevatorManager2,"manager2").start();

        /*
         1. External call : floor 3 up
         2. External call : floor 5 down
         3. Internal call : elevator 1 (press 4)
         4. Internal call : elevator 1 (press 5)
         5. External call : floor 1 Down
         6. External call : floor 2 up
        */
    }

    // building- >floor->ext button- >Extdispatcher- > Ext scheduler -> elevatorManager -> elevators
}
