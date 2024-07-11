package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {
    private Performance performance;
    private Actor actor;
    private String role;

    public Contract(String role) {
        this.role = role;
    }

    protected Contract() {}

    @ManyToOne
    @JoinColumn(name = "performance_id")
    public Performance getPerformance() {
        return performance;
    }

    @ManyToOne
    @JoinColumn(name = "actor_id")
    public Actor getActor() {
        return actor;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
