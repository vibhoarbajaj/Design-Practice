package com.main.desgins.carrental.course.services;

import com.main.desgins.carrental.course.models.Reservation;
import com.main.desgins.carrental.course.models.ReservationStatus;
import com.main.desgins.carrental.course.models.ReservationType;
import com.main.desgins.carrental.self.models.User;
import lombok.AllArgsConstructor;

import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class ReservationManager {
    private final VehicleInventoryManager vehicleInventoryManager;// to update the status
    private final ReservationRepository reservationRepository; // to remove the circular dependency from vehicleinventorymanager
    private final AtomicInteger reservationIdGenerator = new AtomicInteger(20000);

    public Reservation createReservation(int vehicleId, User user, Date from, Date to, ReservationType type) {
        int reservationId = reservationIdGenerator.getAndIncrement();
        boolean reserved = vehicleInventoryManager.reserve(vehicleId, reservationId, from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if (!reserved) {
            throw new RuntimeException("Cannot create reservation");
        }
        Reservation reservation = new Reservation(reservationId, vehicleId, user.getId(), from, to, type, ReservationStatus.IN_USE);
        reservationRepository.save(reservation);
        return reservation;
    }

    public Optional<Reservation> findById(int reservationId) {
        return Optional.ofNullable(reservationRepository.find(reservationId));
    }

    public void cancelReservation(int reservationId) {
        Optional<Reservation> reservation = findById(reservationId);
        if (reservation.isPresent()) {
            Reservation reservationToCancel = reservation.get();
            reservationToCancel.setStatus(ReservationStatus.CANCELLED);
            vehicleInventoryManager.release(reservationToCancel.getVehicleId(), reservationId);
            reservationRepository.remove(reservationToCancel);
        } else {
            throw new RuntimeException("Cannot cancel reservation because reservation does not exist");
        }
    }

    public void startTrip(int reservationId) {
        Reservation r = reservationRepository.find(reservationId);
        r.setStatus(ReservationStatus.IN_USE);
    }

    public void submitVehicle(int reservationId) {
        Reservation reservation = reservationRepository.find(reservationId);
        reservation.setStatus(ReservationStatus.COMPLETED);
        vehicleInventoryManager.release(reservation.getVehicleId(), reservationId);
    }

    public void removeReservation(Reservation reservation) {
        reservationRepository.remove(reservation);
    }

}
