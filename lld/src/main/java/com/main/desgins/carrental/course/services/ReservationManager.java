package com.main.desgins.carrental.course.services;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReservationManager {
    private final VehicleInventoryManager vehicleInventoryManager;// to update the status
    private final ReservationRepository reservationRepository; // to remove the circular dependency from vehicleinventorymanager

}
