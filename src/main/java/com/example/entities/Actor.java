package com.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor extends Worker {
    private Set<Contract> contract;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }
}