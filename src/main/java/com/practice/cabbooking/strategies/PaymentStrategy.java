package com.practice.cabbooking.strategies;


import com.practice.cabbooking.entities.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);

}
