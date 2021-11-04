package com.gromov.models.enums;

public enum Status {
    CANCELED("CANCELED"),ACTIVELY("ACTIVELY"),DELETED("DELETED");
    private String name;
    private Status(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
