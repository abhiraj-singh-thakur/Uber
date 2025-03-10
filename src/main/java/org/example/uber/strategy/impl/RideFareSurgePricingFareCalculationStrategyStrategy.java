package org.example.uber.strategy.impl;

import lombok.RequiredArgsConstructor;
import org.example.uber.entities.RideRequest;
import org.example.uber.services.DistanceService;
import org.example.uber.strategy.RideFairCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategyStrategy implements RideFairCalculationStrategy {

    private static final double SURGE_FACTOR = 2;
    private final DistanceService distanceService;

    @Override
    public double calculateFair(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLIER * SURGE_FACTOR;
    }
}
