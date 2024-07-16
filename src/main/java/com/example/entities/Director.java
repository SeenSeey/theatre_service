package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director extends Worker {
    private Set<Performance> performance;

    @ManyToMany(mappedBy = "director", targetEntity = Performance.class)
    public Set<Performance> getPerformance() {
        return performance;
    }

    public void setPerformance(Set<Performance> performances) {
        this.performance = performances;
    }
}
