package com.main.desgins.carrental.course.bill;

import com.main.desgins.carrental.course.services.ReservationRepository;
import com.main.desgins.carrental.course.services.VehicleInventoryManager;

public class HourlyBill implements BillStratergy {
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationRepository reservationRepository;

    public HourlyBill(VehicleInventoryManager vehicleInventoryManager, ReservationRepository reservationRepository) {
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Bill generateBill(int reservationId) {
        return null;
    }
}
