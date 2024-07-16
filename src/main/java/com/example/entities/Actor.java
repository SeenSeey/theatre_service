package com.example.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor extends Worker {
    private Set<Contract> contract  = new LinkedHashSet<>();

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contracts) {
        this.contract = contract;
    }
}