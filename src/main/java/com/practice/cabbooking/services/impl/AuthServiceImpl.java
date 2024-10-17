package com.practice.cabbooking.services.impl;


import com.practice.cabbooking.Security.JWTService;
import com.practice.cabbooking.dtos.DriverDto;
import com.practice.cabbooking.dtos.SignupDto;
import com.practice.cabbooking.dtos.UserDto;
import com.practice.cabbooking.entities.Driver;
import com.practice.cabbooking.entities.User;
import com.practice.cabbooking.entities.enums.Role;
import com.practice.cabbooking.exceptions.ResourceNotFoundException;
import com.practice.cabbooking.exceptions.RuntimeConflictException;
import com.practice.cabbooking.repositories.UserRepository;
import com.practice.cabbooking.services.AuthService;
import com.practice.cabbooking.services.DriverService;
import com.practice.cabbooking.services.RiderService;
import com.practice.cabbooking.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.practice.cabbooking.entities.enums.Role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private  final PasswordEncoder passwordEncoder;
    private  final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


    @Override
    public String[] login(String email, String password) {
        String token[] = new String[2];
                  Authentication authentication =authenticationManager.
                   authenticate(new UsernamePasswordAuthenticationToken(email,password ));
             User user    = (User) authentication.getPrincipal();
               token[0]=jwtService.generateAccessToken(user);
               token[1]= jwtService.generateRefreshToken(user);
        return token;
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signupDto.getEmail());

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);

//        create user related entities
        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id "+userId));

        if(user.getRoles().contains(DRIVER))
            throw new RuntimeConflictException("User with id "+userId+" is already a Driver");

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }


    @Override
    public String refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found " +
                "with id: "+userId));

        return jwtService.generateAccessToken(user);
    }

}
