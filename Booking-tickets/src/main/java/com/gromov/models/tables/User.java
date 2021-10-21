package com.gromov.models.tables;

import com.gromov.models.interfaces.IObserver;
import com.gromov.models.interfaces.Table;

public class User implements Table, IObserver {
    private String firstName;
    private String lastName;
    private String passportID;
    private String email;
    private String password;
    public User(String firstName, String lastName, String passportID, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportID = passportID;
        this.email = email;
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPassportID() {
        return passportID;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String notify(String event) {
        return "Email: " + email + "\nEvent: " + event;
    }
}
