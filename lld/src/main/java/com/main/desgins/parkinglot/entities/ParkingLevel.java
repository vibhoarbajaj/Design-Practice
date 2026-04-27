package com.main.desgins.parkinglot.entities;

import com.main.desgins.parkinglot.service.ParkingSpotManager;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class ParkingLevel {
    private final int levelNumber;
    private final Map<VehicleType, ParkingSpotManager> managers;

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = managers.get(vehicleType);
        return parkingSpotManager != null && parkingSpotManager.canPark();
    }

    ParkingSpot park(VehicleType vehicleType) {
        return managers.get(vehicleType).park();
    }

    void unpark(ParkingSpot parkingSpot, VehicleType vehicleType) {
        managers.get(vehicleType).unpark(parkingSpot);
    }

}
