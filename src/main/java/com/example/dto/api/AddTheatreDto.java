package com.example.dto.api;

public class AddTheatreDto {
    private String name;
    private String location;
    private String phoneNumber;
    private int numberOfSeats;

    public AddTheatreDto(String name, String location, String phoneNumber, int numberOfSeats) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.numberOfSeats = numberOfSeats;
    }

    protected AddTheatreDto() {}

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
