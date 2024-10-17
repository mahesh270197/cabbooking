package com.practice.cabbooking.services;



import com.practice.cabbooking.entities.Driver;
import com.practice.cabbooking.entities.Ride;
import com.practice.cabbooking.entities.RideRequest;
import com.practice.cabbooking.entities.Rider;
import com.practice.cabbooking.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}