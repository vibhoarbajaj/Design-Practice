package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Data
public class Reservation {

    private final List<Store> stores;
    private final StoreSelectionStrategy storeSelectionStrategy;
    private final BillStrategies billStrategies;
    private final ReentrantLock lock = new ReentrantLock(true);
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ticket reserveCar(RentalVehicleType vehicleType, User user) {
        Store store = storeSelectionStrategy.selectStore(vehicleType, user, stores);
        lock.lock();
        RentalVehicle rentalVehicle;
        try {
            rentalVehicle = store.selectRentalVehicle(vehicleType);
            rentalVehicle.reserveVehicle();
            user.setRentalVehicle(rentalVehicle);

        } finally {
            lock.unlock();

        }
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
            lock.lock();
            try {
                vehicle.unreserveVehicle();
            } finally {
                lock.unlock();
            }
        } else {
            throw new RuntimeException("bill not paid wash the dishes");
        }
    }
}
