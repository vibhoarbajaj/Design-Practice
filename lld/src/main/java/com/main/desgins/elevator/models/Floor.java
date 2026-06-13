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
    public void pressDownButton() {
        downButton.pressButton(this.getFloorNumber(),ElevatorDirection.DOWN);
    }
    public void pressUpButton() {
        upButton.pressButton(this.getFloorNumber(),ElevatorDirection.UP);
    }
}
