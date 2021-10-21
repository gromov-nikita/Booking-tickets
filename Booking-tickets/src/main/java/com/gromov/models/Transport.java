package com.gromov.models;

public class Transport {
    private String number;
    private int amountOfSeats;
    public Transport(String number, int amountOfSeats) {
        this.number = number;
        this.amountOfSeats = amountOfSeats;
    }
    public String getNumber() {
        return number;
    }
    public int getAmountOfSeats() {
        return amountOfSeats;
    }
}
