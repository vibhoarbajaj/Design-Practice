package com.main.desgins.carrental.course.services;


import com.main.desgins.carrental.course.models.Reservation;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ReservationRepository {
    private final Map<Integer, Reservation> reservations;

    public Reservation save(Reservation reservation) {
        return reservations.put(reservation.getReservationId(), reservation);
    }

    public Reservation find(int id) {
        return reservations.get(id);
    }

    public void remove(Reservation reservation) {
        reservations.remove(reservation.getReservationId());
    }


}
