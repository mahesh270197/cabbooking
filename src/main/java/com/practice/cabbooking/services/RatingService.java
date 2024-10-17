package com.practice.cabbooking.services;

import com.practice.cabbooking.dtos.DriverDto;
import com.practice.cabbooking.dtos.RiderDto;
import com.practice.cabbooking.entities.Ride;

public interface RatingService {
    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
