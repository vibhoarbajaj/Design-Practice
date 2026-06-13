package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicle;
import com.main.desgins.carrental.self.models.User;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyBillStrategy implements BillStrategies {
    @Override
    public int getBillForVehicle(RentalVehicle vehicle, User user) {
        LocalDateTime startTime = user.getReservations().getStartTime();
        LocalDateTime endTime = user.getReservations().getEndTime();

        long hours = Duration.between(startTime, endTime).toHours();

        return (int) (vehicle.getCost() * hours);
    }
}
