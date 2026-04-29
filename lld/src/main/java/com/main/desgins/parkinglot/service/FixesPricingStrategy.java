package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.Ticket;

public class FixesPricingStrategy implements PricingStrategy {

    @Override
    public double calculate(Ticket ticket) {
        return 100;
    }
}
