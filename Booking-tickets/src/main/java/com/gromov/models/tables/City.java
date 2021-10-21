package com.gromov.models.tables;


import com.gromov.models.interfaces.Table;

public class City implements Table {
    private String name;
    private String country;
    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
}
