package com.main.desgins.parkinglot.entities.gates;

import com.main.desgins.parkinglot.entities.payment.Payment;
import com.main.desgins.parkinglot.entities.Ticket;
import com.main.desgins.parkinglot.entities.parking.ParkingBuilding;
import com.main.desgins.parkinglot.service.CostComputation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ExitGate {

    @Getter
    private final int exitGateId;
    private final CostComputation costComputation;

    public void exit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment) {
        double amt = calculatePrice(ticket);
        boolean success = payment.pay(amt);
        if (!success) {
            throw new RuntimeException("Payment failed , exit denied");
        }
        parkingBuilding.release(ticket);
        System.out.println("Payment successful");
    }

    private double calculatePrice(Ticket ticket) {
        return costComputation.computeCost(ticket);
    }
}
