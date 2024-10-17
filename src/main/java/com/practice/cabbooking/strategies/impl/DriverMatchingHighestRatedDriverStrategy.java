package com.practice.cabbooking.strategies.impl;



import com.practice.cabbooking.entities.Driver;
import com.practice.cabbooking.entities.RideRequest;
import com.practice.cabbooking.repositories.DriverRepository;
import com.practice.cabbooking.strategies.DriverMatchingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

   private DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {


       return driverRepository.
               findTenNearestTopRatedDrivers(rideRequest.getPickupLocation());

    }
}
