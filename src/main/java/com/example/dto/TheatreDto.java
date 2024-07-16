package com.example.dto;

public class TheatreDto {
    private int id;
    private String name;
    private String location;
    private String phoneNumber;
    private int numberOfSeats;

    public TheatreDto(int id, String name, String location, String phoneNumber, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.numberOfSeats = numberOfSeats;
    }

    protected TheatreDto() {}

    public int getId() {
        return id;
    }

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

    public void setId(int id) {
        this.id = id;
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
