package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.ParkingSpot;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {

    protected final List<ParkingSpot> spots;
    protected final ParkingSpotLookupStrategy spotLookupStrategy;
    private final ReentrantLock lock = new ReentrantLock(true);
    // note : we used reentrant lock because its using fifo , can use synchronize but that won't be fifo

    protected ParkingSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy spotLookupStrategy) {
        this.spots = spots;
        this.spotLookupStrategy = spotLookupStrategy;
    }

    public ParkingSpot park() {
        lock.lock();
        try {
            ParkingSpot parkingSpot = spotLookupStrategy.getParkingSpot(spots);
            if (parkingSpot == null) {
                return null;
            }
            parkingSpot.occupySpot();
            return parkingSpot;

        } finally {
            lock.unlock();
        }
    }

    public void unpark(ParkingSpot spot) {
        lock.lock();
        try {
            spot.releaseSpot();
        } finally {
            lock.unlock();
        }
    }

    public boolean canPark() {
        lock.lock();
        try {
            return spots.stream().anyMatch(ParkingSpot::isSpotFree);
        } catch (Exception e) {
            return false;
        }
    }

}
