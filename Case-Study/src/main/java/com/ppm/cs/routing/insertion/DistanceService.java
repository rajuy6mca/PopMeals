package com.ppm.cs.routing.insertion;

public interface DistanceService {
    /**
     * Returns the duration in seconds to get from Delivery `a` to Delivery
     `b`.
     * The following always holds: getDistance(a, b) == getDistance(b, a)
     */
    int getDurationInSeconds(Delivery a, Delivery b);

    /**
     * Returns distance in meters
     */
    int getDistanceInMeters(Delivery a, Delivery b);

}
