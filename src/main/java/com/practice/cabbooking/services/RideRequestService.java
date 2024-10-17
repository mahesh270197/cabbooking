package com.practice.cabbooking.services;

import com.practice.cabbooking.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}