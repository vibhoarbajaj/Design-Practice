package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicle;
import com.main.desgins.carrental.self.models.User;

public class DailyBillStrategy implements BillStrategies{
    @Override
    public int getBillForVehicle(RentalVehicle vehicle, User user) {
        return 0;
    }
}
