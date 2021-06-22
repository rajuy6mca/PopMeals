package com.ppm.cs.routing.insertion;

import java.util.List;

public interface InsertionService {

    /**
     * Returns an insertion for `deliveryToInsert` into any of the provided
     `routes` with an index
     */
    Insertion findInsertion(Delivery deliveryToInsert, List<Route> routes);

    /**
     * Returns an insertion for `deliveryToInsert` into any of the provided
     `routes` with an index
     */
    Insertion findInsertion(Delivery deliveryToInsert, List<Route> routes,
            int weightForTime, int weightForDistance);

}
