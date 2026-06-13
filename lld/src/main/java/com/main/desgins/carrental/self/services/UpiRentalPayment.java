package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalPayment;

public class UpiRentalPayment implements RentalPayment {
    @Override
    public boolean pay(int cost) {
        System.out.println("Paying " + cost + " through upi");
        return true;
    }
}
