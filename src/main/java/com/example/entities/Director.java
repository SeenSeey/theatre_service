package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director extends Worker {
    private Set<Performance> performance;

//    protected Director() {}

//    public Director(String name, String surname, String education, String award, CategoryForWorker category) {
//        super(name, surname, education, award, category);
//    }

    @ManyToMany(mappedBy = "director", targetEntity = Performance.class)
    public Set<Performance> getPerformances() {
        return performance;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performance = performances;
    }
}
