package com.main.desgins.parkinglot.entities;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class ParkingBuilding {

    private final List<ParkingLevel> parkingLevels;

    public Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : parkingLevels) { // this can be dynamic too
            if (parkingLevel.hasAvailability(vehicle.getVehicleType())) {
                ParkingSpot parkingSpot = parkingLevel.park(vehicle.getVehicleType());
                if (parkingSpot != null) {
                    System.out.println("parking spot has been allocated at level : " + parkingLevel.getLevelNumber() + " spot is : " + parkingSpot.getParkingSpotId());
                    return new Ticket(vehicle, parkingLevel, parkingSpot, LocalDateTime.now());
                }
            }
        }
        return null;
    }

    void release(Ticket ticket) {
        ticket.getParkingLevel().unpark(ticket.getParkingSpot(), ticket.getVehicle().getVehicleType());
    }

}
