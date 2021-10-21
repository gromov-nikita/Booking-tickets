package com.gromov.models.tables;

import com.gromov.models.interfaces.Table;

public class Path implements Table {
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
