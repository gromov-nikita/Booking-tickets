package com.gromov.models;

public class User {
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
}
