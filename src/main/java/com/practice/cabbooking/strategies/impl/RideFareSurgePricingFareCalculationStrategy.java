package com.practice.cabbooking.strategies.impl;


import com.practice.cabbooking.entities.RideRequest;
import com.practice.cabbooking.services.DistanceService;
import com.practice.cabbooking.strategies.RideFareCalculationStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
     public static  double SURGE_FACTOR = 2;
    private  DistanceService distanceService;



    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER * SURGE_FACTOR;
    }
}
