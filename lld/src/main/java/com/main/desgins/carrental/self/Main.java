package com.main.desgins.carrental.self;

import com.main.desgins.carrental.self.models.*;
import com.main.desgins.carrental.self.services.HourlyBillStrategy;
import com.main.desgins.carrental.self.services.NearestStoreStrategy;
import com.main.desgins.carrental.self.services.Reservation;
import com.main.desgins.carrental.self.services.UpiRentalPayment;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setLocation(Location.builder().x(10).y(10).build());

        List<RentalVehicle> rentalVehicles = new ArrayList<>();
        rentalVehicles.add(RentalVehicle.builder().id(1).rentalVehicleType(RentalVehicleType.FOUR_WHEELER).vehicleNumber(123).cost(120).isFree(true).build());
        rentalVehicles.add(RentalVehicle.builder().id(2).rentalVehicleType(RentalVehicleType.TWO_WHEELER).vehicleNumber(1234).cost(100).isFree(true).build());
        List<Store> stores = new ArrayList<>();
        Store store1 = new Store("store1", "123", rentalVehicles, Location.builder().x(11).y(11).build());
        stores.add(store1);
        Reservation reservation = new Reservation(stores, new NearestStoreStrategy(), new HourlyBillStrategy(), null, null);
        Ticket ticket = reservation.reserveCar(RentalVehicleType.FOUR_WHEELER, user);
        reservation.returnCar(ticket, new UpiRentalPayment());
    }
}
