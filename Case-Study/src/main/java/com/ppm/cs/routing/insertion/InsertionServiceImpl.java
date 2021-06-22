package com.ppm.cs.routing.insertion;

import java.util.List;

public class InsertionServiceImpl implements InsertionService {

    private DistanceService distanceService;

    public InsertionServiceImpl(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public Insertion findInsertion(Delivery deliveryToInsert, List<Route> routes) {
        int duration = -1, finalIndex = 0;
        Route finalRoute = null;
        // Navigate routes
        for (Route route : routes) {
            int index = 0;
            // Navigate deliveries
            for (Delivery confirmed : route.getDeliveries()) {
                int calcDuration = distanceService.getDurationInSeconds(confirmed, deliveryToInsert);
                // Is duration less than previous one.
                if ((calcDuration <= duration) || (duration == -1)) {
                    duration = calcDuration;
                    finalRoute = route;
                    finalIndex = index;
                }
                index++;
            }
        }
        return new Insertion(finalRoute, deliveryToInsert, finalIndex);
    }

    @Override
    public Insertion findInsertion(Delivery deliveryToInsert, List<Route> routes, int weightForTime, int weightForDistance) {
        int finalWeight = -1, finalIndex = 0;
        Route finalRoute = null;
        // Navigate routes
        for (Route route : routes) {
            int index = 0;
            // Navigate deliveries
            for (Delivery confirmed : route.getDeliveries()) {
                int calcDuration = distanceService.getDurationInSeconds(confirmed, deliveryToInsert);
                int calcDistance = distanceService.getDistanceInMeters(confirmed, deliveryToInsert);
                int calcWeight = (calcDuration * weightForTime) + (calcDistance * weightForDistance);
                // Is duration less than previous one.
                if ((calcWeight <= finalWeight) || (finalWeight == -1)) {
                    finalWeight = calcDuration;
                    finalRoute = route;
                    finalIndex = index;
                }
                index++;
            }
        }
        return new Insertion(finalRoute, deliveryToInsert, finalIndex);
    }
}
