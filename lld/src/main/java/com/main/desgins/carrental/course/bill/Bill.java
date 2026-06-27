package com.main.desgins.carrental.course.bill;

import lombok.Data;

@Data
public class Bill {
    private int reservationId;
    private int billId;
    private double totalBillAmt;
    private boolean isBillPaid;
}
