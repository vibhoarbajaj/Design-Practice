package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalPayment;

public class CashRentalPayment implements RentalPayment {
    @Override
    public boolean pay(int cost) {
        return false;
    }
}
