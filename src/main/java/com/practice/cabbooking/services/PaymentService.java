package com.practice.cabbooking.services;

import com.practice.cabbooking.entities.Payment;
import com.practice.cabbooking.entities.Ride;
import com.practice.cabbooking.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
