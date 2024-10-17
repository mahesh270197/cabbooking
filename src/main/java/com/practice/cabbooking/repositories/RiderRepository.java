package com.practice.cabbooking.repositories;


import com.practice.cabbooking.entities.Rider;
import com.practice.cabbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {

    Optional<Rider> findByUser(User user);
}
