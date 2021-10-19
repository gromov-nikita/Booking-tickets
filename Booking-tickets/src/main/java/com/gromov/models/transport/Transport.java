package com.gromov.models.transport;

import java.util.ArrayList;
import java.util.List;

public class Transport {
    private String name;
    private int amountOfSeats = 0;
    private int amountOfFreeSeats;
    private List<List<List<Boolean>>> seats = new ArrayList<List<List<Boolean>>>();
    public Transport(String name, int amountOfFloors, int[] amountOfRows, int[] amountOfColumns) {
        this.name = name;
        for(int i = 0; i < amountOfFloors; i++) {
            seats.add(new ArrayList<>());
            for(int j = 0; j < amountOfRows[i]; j++) {
                seats.get(i).add(new ArrayList<>());
                for(int k = 0; k < amountOfColumns[i]; k++) {
                    amountOfSeats++;
                    seats.get(i).get(j).add(false);
                }
            }
        }
        amountOfFreeSeats = amountOfSeats;
    }
    public String getName() {
        return name;
    }
    public List<List<List<Boolean>>> getSeats() {
        return seats;
    }
    public int getAmountOfSeats() {
        return amountOfSeats;
    }
    public int getAmountOfFreeSeats() {
        return amountOfFreeSeats;
    }
    public List<String> getLayOut() {
        List<String> floorsLayout = new ArrayList<String>();
        StringBuilder stringMaker;
        for(int i = 0; i < seats.size(); i++) {
            stringMaker = new StringBuilder();
            stringMaker.append("Floor №");
            stringMaker.append(i);
            stringMaker.append("\n");
            for(int j = 0; j < seats.get(i).size(); j++) {
                stringMaker.append("Row №");
                stringMaker.append(j);
                stringMaker.append("\n");
                for(int  k = 0; k < seats.get(i).get(j).size(); k++) {
                    stringMaker.append(seats.get(i).get(j).get(k));
                    stringMaker.append(" ");
                }
                stringMaker.append("\nAmount of seats: ");
                stringMaker.append(seats.get(i).get(j).size());
                stringMaker.append("\n\n");
            }
            stringMaker.append("\n\n\n");
            floorsLayout.add(String.valueOf(stringMaker));
        }
        return floorsLayout;
    }
}
