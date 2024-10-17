package com.practice.cabbooking.services;



import com.practice.cabbooking.dtos.DriverDto;
import com.practice.cabbooking.dtos.RideDto;
import com.practice.cabbooking.dtos.RideRequestDto;
import com.practice.cabbooking.dtos.RiderDto;
import com.practice.cabbooking.entities.Rider;
import com.practice.cabbooking.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

   ;

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
