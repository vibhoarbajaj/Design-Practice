package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicle;
import com.main.desgins.carrental.self.models.User;

public interface BillStrategies {
    int getBillForVehicle(RentalVehicle vehicle, User user);
}
