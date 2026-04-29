package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.parking.ParkingSpot;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {

    public FourWheelerSpotManager(List<ParkingSpot> spot, ParkingSpotLookupStrategy spotLookupStratergy) {
        super(spot, spotLookupStratergy);
    }
}
