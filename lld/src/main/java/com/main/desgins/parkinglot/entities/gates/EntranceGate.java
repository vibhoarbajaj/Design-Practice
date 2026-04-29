package com.main.desgins.parkinglot.entities.gates;

import com.main.desgins.parkinglot.entities.parking.ParkingBuilding;
import com.main.desgins.parkinglot.entities.Ticket;
import com.main.desgins.parkinglot.entities.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class EntranceGate {
    @Getter
    private final int entranceGateId;
    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
        return parkingBuilding.allocate(vehicle);
    }


}
