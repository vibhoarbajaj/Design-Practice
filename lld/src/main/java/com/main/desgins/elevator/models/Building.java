package com.main.desgins.elevator.models;

import com.main.desgins.elevator.strategy.ExternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class Building {

    List<Floor> floors = new ArrayList<>();

    public Building(int totalFloors, ExternalDispatcher externalDispatcher) {
        for (int i = 0; i < totalFloors; i++) {
            floors.add(new Floor(i, externalDispatcher));
        }
    }

    public Floor getFloor(int FloorNumber) {
        return floors.get(FloorNumber);
    }

}
