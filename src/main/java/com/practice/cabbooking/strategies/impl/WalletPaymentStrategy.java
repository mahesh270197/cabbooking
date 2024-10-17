package com.practice.cabbooking.strategies.impl;


import com.practice.cabbooking.entities.Payment;
import com.practice.cabbooking.repositories.PaymentRepository;
import com.practice.cabbooking.services.WalletService;
import com.practice.cabbooking.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Rider had 232, Driver had 500
//Ride cost is 100, commission = 30
//Rider -> 232-100 = 132
//Driver -> 500 + (100 - 30) = 570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

    }


}
