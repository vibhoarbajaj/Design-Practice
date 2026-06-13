package com.main.desgins.carrental.self.models;

import com.main.desgins.carrental.self.services.BillStrategies;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Bill {
    private final BillStrategies billStrategies;

    public int getBill(User user, RentalVehicle vehicle) {
        return billStrategies.getBillForVehicle(vehicle, user);
    }

}
