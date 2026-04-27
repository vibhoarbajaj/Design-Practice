package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.ParkingSpot;

import java.util.List;

public class RandomParkingStrategy implements ParkingSpotLookupStrategy {
    @Override
    public ParkingSpot getParkingSpot(List<ParkingSpot> spots) {
        for(ParkingSpot spot : spots){
            if(!spot.isParked()){
                return spot;
            }
        }
        return null;
    }
}
