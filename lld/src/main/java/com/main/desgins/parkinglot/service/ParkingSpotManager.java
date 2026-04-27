package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.ParkingSpot;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {

    protected final List<ParkingSpot> Spot;
    protected final ParkingSpotLookupStrategy spotLookupStratergy;
    private final ReentrantLock lock = new ReentrantLock(true);

    protected ParkingSpotManager(List<ParkingSpot> spot, ParkingSpotLookupStrategy spotLookupStratergy) {
        this.Spot = spot;
        this.spotLookupStratergy = spotLookupStratergy;
    }

    public ParkingSpot park() {
        return null;
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
            return Spot.stream().noneMatch(ParkingSpot::isSpotFree);
        } catch (Exception e) {
            return false;
        }
    }

}
