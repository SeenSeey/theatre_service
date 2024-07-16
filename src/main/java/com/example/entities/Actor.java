package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor extends Worker {
    private Set<Contract> contract;

//    protected Actor() {
//    }

//    public Actor(String name, String surname, String education, String award, CategoryForWorker category) {
//        super(name, surname, education, award, category);
//    }

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contracts) {
        this.contract = contract;
    }
}