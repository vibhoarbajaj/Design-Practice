package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookupStrategy {
    ParkingSpot getParkingSpot(List<ParkingSpot> spots);
}
