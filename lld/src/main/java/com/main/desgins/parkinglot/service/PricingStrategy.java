package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.Ticket;

public interface PricingStrategy {

    double calculate(Ticket ticket);
}
