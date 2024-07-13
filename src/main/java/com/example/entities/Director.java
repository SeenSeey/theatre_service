package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director extends Worker {
    private Set<Performance> performances;

    protected Director() {}

    public Director(String name, String surname, String education, String award) {
        super(name, surname, education, award);
    }

    @ManyToMany(mappedBy = "director", targetEntity = Performance.class)
    public Set<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}
