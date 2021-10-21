package com.gromov.models;

public class Path {
    private City from;
    private City to;
    public Path(City from, City to) {
        this.from = from;
        this.to = to;
    }
    public City getFrom() {
        return from;
    }
    public City getTo() {
        return to;
    }
}
