package com.main.desgins.parkinglot.entities.parking;

import com.main.desgins.parkinglot.entities.Ticket;
import com.main.desgins.parkinglot.entities.gates.EntranceGate;
import com.main.desgins.parkinglot.entities.gates.ExitGate;
import com.main.desgins.parkinglot.entities.payment.Payment;
import com.main.desgins.parkinglot.entities.vehicle.Vehicle;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final List<EntranceGate> entranceGate; //  can be list of entrance gate as well
    private final List<ExitGate> exitGate;

    public Ticket vehicleArrives(Vehicle vehicle) {
        for(EntranceGate entranceGate : entranceGate){
            if(entranceGate.getEntranceGateId()== vehicle.getEntryGateNumber()){
                System.out.println("vehicle arrives " + vehicle.getVehicleNumber() + "to the gate " + vehicle.getEntryGateNumber());
                return entranceGate.enter(parkingBuilding, vehicle);
            }
        }
        throw new RuntimeException("cannot find any valid gate to enter");
    }

    public void vehicleExit(Ticket ticket, Payment payment) {
        for (ExitGate exitGate : exitGate) {
            if (exitGate.getExitGateId() == ticket.getVehicle().getExitGateNumber()) {
                exitGate.exit(parkingBuilding, ticket, payment);
                System.out.println("vehicle exits " + ticket.getVehicle().getVehicleNumber() + "to the gate " + ticket.getVehicle().getExitGateNumber());
            }
        }
    }
}
