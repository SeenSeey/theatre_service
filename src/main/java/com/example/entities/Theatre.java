package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "theatre")
public class Theatre extends BaseEntity {
    private String name;
    private String location;
    private String phoneNumber;
    private int numberOfSeats;
    private Set<Performance> performance;

    protected Theatre() {}

    public Theatre(String name, String location, String phoneNumber, int numberOfSeats) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.numberOfSeats = numberOfSeats;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Column(name = "number_of_seats")
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    public Set<Performance> getPerformance() {
        return performance;
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

    public void setPerformance(Set<Performance> performance) {
        this.performance = performance;
    }
}

