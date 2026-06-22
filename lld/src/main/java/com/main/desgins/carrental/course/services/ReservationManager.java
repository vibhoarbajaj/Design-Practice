package com.main.desgins.carrental.course.services;

import com.main.desgins.carrental.course.models.Reservation;
import com.main.desgins.carrental.course.models.ReservationType;
import com.main.desgins.carrental.self.models.User;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class ReservationManager {
    private final VehicleInventoryManager vehicleInventoryManager;// to update the status
    private final ReservationRepository reservationRepository; // to remove the circular dependency from vehicleinventorymanager
    private final ReservationIdGenerator reservationIdGenerator;

    public Reservation createReservation(int vehicleId , User user , LocalDate from, LocalDate to, ReservationType type) {
        int reservationId = reservationIdGenerator.getAndIncrement();
        return null;
    }
}
