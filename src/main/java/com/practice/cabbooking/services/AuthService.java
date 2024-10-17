package com.practice.cabbooking.services;


import com.practice.cabbooking.dtos.DriverDto;
import com.practice.cabbooking.dtos.SignupDto;
import com.practice.cabbooking.dtos.UserDto;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);
}
