package Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {
    private int id;
    private String name;
    private String surname;
    private String education;
    private String award;
    private Set<Performance> performance;

    public Actor() {}

    public Actor(String name, String surname, String education, String award) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.award = award;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    @Column(name = "award")
    public String getAward() {
        return award;
    }

    @ManyToMany(mappedBy = "actor", targetEntity = Performance.class)
    public Set<Performance> getPerformance() {
        return performance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public void setPerformance(Set<Performance> performance) {
        this.performance = performance;
    }
}
