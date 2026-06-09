package com.main.desgins.elevator.models;

import com.main.desgins.elevator.strategy.ExternalButton;
import com.main.desgins.elevator.strategy.ExternalDispatcher;
import lombok.Data;

@Data

public class Floor {
    int FloorNumber;
    ExternalButton upButton;
    ExternalButton downButton;
    public Floor(int FloorNumber , ExternalDispatcher dispatcher) {
        this.FloorNumber = FloorNumber;
        this.upButton= new ExternalButton(dispatcher);
        this.downButton= new ExternalButton(dispatcher);
    }
    public void pressDownButton(int floor) {
        downButton.pressButton(floor,ElevatorDirection.DOWN);
    }
    public void pressUpButton(int floor) {
        upButton.pressButton(floor,ElevatorDirection.UP);
    }
}
