package com.main.desgins.parkinglot.entities.parking;

import com.main.desgins.parkinglot.entities.payment.Payment;
import com.main.desgins.parkinglot.entities.Ticket;
import com.main.desgins.parkinglot.entities.gates.EntranceGate;
import com.main.desgins.parkinglot.entities.gates.ExitGate;
import com.main.desgins.parkinglot.entities.vehicle.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final EntranceGate entranceGate; //  can be list of entrance gate as well
    private final ExitGate exitGate;

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entranceGate.enter(parkingBuilding, vehicle);
    }
    public void vehicleExit(Ticket ticket , Payment payment) {
        exitGate.exit( parkingBuilding, ticket , payment);
    }
}
