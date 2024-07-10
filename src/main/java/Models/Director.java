package Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director {
    private int id;
    private String name;
    private String surname;
    private String education;
    private String award;
    private Set<Performance> performances;

    public Director() {}

    public Director(String name, String surname, String education, String award) {
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

    @ManyToMany(mappedBy = "director", targetEntity = Performance.class)
    public Set<Performance> getPerformances() {
        return performances;
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

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}
