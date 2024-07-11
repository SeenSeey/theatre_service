package entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "performance")
public class Performance extends BaseEntity {
    private Theatre theatre;
    private Set<Director> director;
    private Set<Actor> actor;
    private String name;
    private String timeIntervalPerformance;
    private Date dateOfPerformance;
    private String author;

    public Performance() {}

    public Performance(String name, String timeIntervalPerformance, Date dateOfPerformance, String author) {
        this.name = name;
        this.timeIntervalPerformance = timeIntervalPerformance;
        this.dateOfPerformance = dateOfPerformance;
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    public Theatre getTheatre() {
        return theatre;
    }

    @ManyToMany
    @JoinColumn(name = "director_id")
    public Set<Director> getDirector() {
        return director;
    }

    @ManyToMany
    @JoinColumn(name = "actor_id")
    public Set<Actor> getActor() {
        return actor;
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

    public void setDirector(Set<Director> director) {
        this.director = director;
    }

    public void setActor(Set<Actor> actor) {
        this.actor = actor;
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
