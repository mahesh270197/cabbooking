package com.practice.cabbooking.services.impl;

import com.practice.cabbooking.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_BASE_URL = "http://router.project-osrm.org/route/v1/driving";

    private final WebClient webClient;

    public DistanceServiceOSRMImpl() {
        this.webClient = WebClient.builder().baseUrl(OSRM_BASE_URL).build();
    }

    @Override
    public double calculateDistance(Point src, Point dest) {
        try {
            // Build the URI with coordinates
            String uri = String.format("/%f,%f;%f,%f", src.getX(), src.getY(), dest.getX(), dest.getY());

            // Make the WebClient call and retrieve the response
            ORSMResponseDto osrmResponseDto = webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(ORSMResponseDto.class)
                    .block(); // Block the call (synchronous)

            // Return the distance in kilometers
            return osrmResponseDto.getRoutes().get(0).getDistance() / 1000.0;
        } catch (Exception e) {
            throw new RuntimeException("Error getting OSRM data: " + e.getMessage());
        }
    }

    @Data
    private static class ORSMResponseDto {
        private List<ORSMRoutes> routes;
    }

    @Data
    private static class ORSMRoutes {
        private double distance;
    }
}
