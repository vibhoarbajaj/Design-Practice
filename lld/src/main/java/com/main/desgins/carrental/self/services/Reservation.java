package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Reservation {

    private final List<Store> stores;
    private final StoreSelectionStrategy storeSelectionStrategy;
    private final BillStrategies billStrategies;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ticket reserveCar(RentalVehicleType vehicleType, User user) {
        Store store = storeSelectionStrategy.selectStore(vehicleType, user, stores);
        RentalVehicle rentalVehicle = store.selectRentalVehicle(vehicleType);
        rentalVehicle.reserveVehicle();
        user.setRentalVehicle(rentalVehicle);
        this.startTime = LocalDateTime.now();
        user.setReservations(this);
        return new Ticket(UUID.randomUUID(), rentalVehicle, user);
    }

    public void returnCar(Ticket ticket, RentalPayment rentalPayment) {
        this.endTime = LocalDateTime.now(); // this is critical as per the code
        User user = ticket.getUser();
        int billCost = billStrategies.getBillForVehicle(ticket.getVehicle(), user);
        boolean isPaid = rentalPayment.pay(billCost);
        if (isPaid) {
            System.out.println("congratulations the bill is paid for car " + ticket.getVehicle().getVehicleNumber() + " and user " + ticket.getUser().getUsername());
            RentalVehicle vehicle = ticket.getVehicle();
            vehicle.unreserveVehicle();
        } else {
            throw new RuntimeException("bill not paid wash the dishes");
        }
    }
}
