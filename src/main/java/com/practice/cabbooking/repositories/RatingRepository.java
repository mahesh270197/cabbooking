package com.practice.cabbooking.repositories;

import com.practice.cabbooking.entities.Driver;
import com.practice.cabbooking.entities.Rating;
import com.practice.cabbooking.entities.Ride;
import com.practice.cabbooking.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRider(Rider rider);
    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
