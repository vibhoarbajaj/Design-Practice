package com.main.desgins.carrental.course.models;

import com.main.desgins.carrental.course.services.ReservationManager;
import com.main.desgins.carrental.course.services.VehicleInventoryManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Store {
    private VehicleInventoryManager vehicleInventoryManager;
    private ReservationManager reservationManager;
}
