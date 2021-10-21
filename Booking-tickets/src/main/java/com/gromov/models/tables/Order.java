package com.gromov.models.tables;

import com.gromov.models.interfaces.Table;

public class Order implements Table {
    private User user;
    private Trip trip;
    private int seat;
    private double price;
    public Order(User user, Trip trip, int seat, double price) {
        this.user = user;
        this.trip = trip;
        this.seat = seat;
        this.price = price;
    }
    public User getUser() {
        return user;
    }
    public Trip getTrip() {
        return trip;
    }
    public int getSeat() {
        return seat;
    }
    public double getPrice() {
        return price;
    }
}
