package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.parking.ParkingSpot;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {

    protected TwoWheelerSpotManager(List<ParkingSpot> spot, ParkingSpotLookupStrategy spotLookupStratergy) {
        super(spot, spotLookupStratergy);
    }
}
