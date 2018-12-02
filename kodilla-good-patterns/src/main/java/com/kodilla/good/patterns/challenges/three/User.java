package com.kodilla.good.patterns.challenges.three;

public class User {
    private String username;
    private String realNameAndSurname;
    private int ID;
    private String emailAddress;
    private String postalAddress;
    private int phoneNumber;

    //simplified constructor for practice usage
    public User(String username) {
        this.username = username;
    }

    public User(String username, String realNameAndSurname, int ID, String emailAddress, String postalAddress, int phoneNumber) {
        this.username = username;
        this.realNameAndSurname = realNameAndSurname;
        this.ID = ID;
        this.emailAddress = emailAddress;
        this.postalAddress = postalAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealNameAndSurname() {
        return realNameAndSurname;
    }

    public void setRealNameAndSurname(String realNameAndSurname) {
        this.realNameAndSurname = realNameAndSurname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
