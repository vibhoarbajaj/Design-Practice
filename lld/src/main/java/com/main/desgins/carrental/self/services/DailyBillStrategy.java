package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicle;
import com.main.desgins.carrental.self.models.User;

import java.time.Duration;
import java.time.LocalDateTime;

public class DailyBillStrategy implements BillStrategies {
    @Override
    public int getBillForVehicle(RentalVehicle vehicle, User user) {
        LocalDateTime startTime = user.getReservations().getStartTime();
        LocalDateTime endTime = user.getReservations().getEndTime();

        long days = Duration.between(startTime, endTime).toDays();

        return (int) (vehicle.getCost() * days);
    }
}
