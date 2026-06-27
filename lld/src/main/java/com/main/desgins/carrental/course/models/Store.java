package com.main.desgins.carrental.course.models;

import com.main.desgins.carrental.course.bill.BillManager;
import com.main.desgins.carrental.course.services.ReservationManager;
import com.main.desgins.carrental.course.services.VehicleInventoryManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Store {// orchestator
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillManager billManager;


}
