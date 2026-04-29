package com.main.desgins.parkinglot.service;

import com.main.desgins.parkinglot.entities.Ticket;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CostComputation {

    private final PricingStrategy pricingStrategy;

    public double computeCost(Ticket ticket) {
        return pricingStrategy.calculate(ticket);
    }
}
