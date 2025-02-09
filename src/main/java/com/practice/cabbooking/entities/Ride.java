package com.practice.cabbooking.entities;


import com.practice.cabbooking.entities.enums.PaymentMethod;
import com.practice.cabbooking.entities.enums.PaymentMethods;
import com.practice.cabbooking.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}

