package com.practice.cabbooking.services.impl;


import com.practice.cabbooking.dtos.RideRequestDto;
import com.practice.cabbooking.entities.Driver;
import com.practice.cabbooking.entities.Ride;
import com.practice.cabbooking.entities.RideRequest;
import com.practice.cabbooking.entities.Rider;
import com.practice.cabbooking.entities.enums.RideStatus;
import com.practice.cabbooking.repositories.RideRepository;
import com.practice.cabbooking.services.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }


    @Override
    public Ride createNewRide(RideRequest rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
            ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
        return null;
    }



}
