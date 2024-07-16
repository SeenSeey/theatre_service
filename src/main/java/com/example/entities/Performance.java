package com.example.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "performance")
public class Performance extends BaseEntity {
    private Theatre theatre;
    private Set<Director> director;
    private Set<Contract> contract  = new LinkedHashSet<>();
    private String name;
    private String timeIntervalPerformance;
    private Date dateOfPerformance;
    private String author;

    protected Performance() {}

    public Performance(Theatre theatre, String name, String timeIntervalPerformance, Date dateOfPerformance, String author) {
        this.theatre = theatre;
        this.name = name;
        this.timeIntervalPerformance = timeIntervalPerformance;
        this.dateOfPerformance = dateOfPerformance;
        this.author = author;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theatre_id")
    public Theatre getTheatre() {
        return theatre;
    }

    @ManyToMany
    @JoinTable(
            name = "performance_director",
            joinColumns = @JoinColumn(name = "performance_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    public Set<Director> getDirector() {
        return director;
    }

    @OneToMany(mappedBy = "performance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Contract> getContract() {
        return contract;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "time_interval_performance")
    public String getTimeIntervalPerformance() {
        return timeIntervalPerformance;
    }

    @Column(name = "date_of_performance")
    public Date getDateOfPerformance() {
        return dateOfPerformance;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public void setDirector(Set<Director> director) {
        this.director = director;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeIntervalPerformance(String timeIntervalPerformance) {
        this.timeIntervalPerformance = timeIntervalPerformance;
    }

    public void setDateOfPerformance(Date dateOfPerformance) {
        this.dateOfPerformance = dateOfPerformance;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
