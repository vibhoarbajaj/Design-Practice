package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.ParkingSpot;

import java.util.List;

public class NearestFirstParkingStrategy implements ParkingSpotLookupStrategy {
    @Override
    public ParkingSpot getParkingSpot(List<ParkingSpot> spots) {
        for(ParkingSpot spot : spots){
            if(spot.isSpotFree()){
                return spot;
            }
        }
        return null;
    }
}
