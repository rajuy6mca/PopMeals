package com.ppm.cs.routing.insertion;

public class Insertion {

    private final Route route;
    private final Delivery delivery;
    private final int index;

    public Insertion(Route route, Delivery delivery, int index) {
        this.route = route;
        this.delivery = delivery;
        this.index = index;
    }

    public Route getRoute() {
        return route;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public int getIndex() {
        return index;
    }

}
