package com.practice.cabbooking.services;


import com.practice.cabbooking.entities.Ride;
import com.practice.cabbooking.entities.User;
import com.practice.cabbooking.entities.Wallet;
import com.practice.cabbooking.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount,
                            String transactionId, Ride ride,
                            TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount,
                                 String transactionId, Ride ride,
                                 TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);

}
