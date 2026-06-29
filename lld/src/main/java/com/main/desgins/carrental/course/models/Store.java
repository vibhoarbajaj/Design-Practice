package com.main.desgins.carrental.course.models;

import com.main.desgins.carrental.course.bill.Bill;
import com.main.desgins.carrental.course.bill.BillManager;
import com.main.desgins.carrental.course.bill.BillStratergy;
import com.main.desgins.carrental.course.services.ReservationManager;
import com.main.desgins.carrental.course.services.VehicleInventoryManager;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Store {// orchestator
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillManager billManager;

    public Bill generateBill(int reservationId, BillStratergy stratergy) {
        return stratergy.generateBill(reservationId);
    }

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }
    public Reservation createReservation(int vehicleId, User user, Date from, Date to,
                                         ReservationType type)  {
        return reservationManager.createReservation(vehicleId, user, from, to, type);
    }


}
