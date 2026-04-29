package com.main.desgins.parkinglot.entities.gates;

import com.main.desgins.parkinglot.entities.parking.ParkingBuilding;
import com.main.desgins.parkinglot.entities.Ticket;
import com.main.desgins.parkinglot.entities.vehicle.Vehicle;

public class EntranceGate {

    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
        return parkingBuilding.allocate(vehicle);
    }


}
