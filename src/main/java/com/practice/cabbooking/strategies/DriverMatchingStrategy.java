package com.practice.cabbooking.strategies;



import com.practice.cabbooking.entities.Driver;
import com.practice.cabbooking.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
