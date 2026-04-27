package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.ParkingSpot;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {

    protected FourWheelerSpotManager(List<ParkingSpot> spot, ParkingSpotLookupStrategy spotLookupStratergy) {
        super(spot, spotLookupStratergy);
    }
}
