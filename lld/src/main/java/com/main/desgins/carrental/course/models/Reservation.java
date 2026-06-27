package com.main.desgins.carrental.course.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Reservation {
    private int reservationId;
    private int vehicleId;
    private int userId;
    private Date bookingDateFrom;
    private Date bookingDateTo;
    private ReservationType reservationType;
    private ReservationStatus status;
}
