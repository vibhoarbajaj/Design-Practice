package com.main.desgins.parkinglot.entities;

import com.main.desgins.parkinglot.service.ParkingSpotManager;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ParkingLevel {
    private final int levelNumber;
    private final Map<VehicleType , ParkingSpotManager> managers;

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = managers.get(vehicleType);
        return parkingSpotManager!=null && parkingSpotManager.canPark();
    }

    ParkingSpot Park(VehicleType vehicleType){
        return null;
    }
    void unpark(ParkingSpot parkingSpot, VehicleType vehicleType){
    }

}
