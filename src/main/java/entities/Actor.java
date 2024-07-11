package entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor extends Worker {
    private Set<Contract> contracts;

    protected Actor() {
    }

    public Actor(String name, String surname, String education, String award) {
        super(name, surname, education, award);
    }

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}