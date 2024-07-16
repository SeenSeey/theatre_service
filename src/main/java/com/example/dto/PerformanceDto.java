package com.example.dto;

import java.util.Date;

public class PerformanceDto {
    private int id;
    private String name;
    private String timeIntervalPerformance;
    private Date dateOfPerformance;
    private String author;

    public PerformanceDto(int id, String name, String timeIntervalPerformance, Date dateOfPerformance, String author) {
        this.id = id;
        this.name = name;
        this.timeIntervalPerformance = timeIntervalPerformance;
        this.dateOfPerformance = dateOfPerformance;
        this.author = author;
    }

    protected PerformanceDto() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTimeIntervalPerformance() {
        return timeIntervalPerformance;
    }

    public Date getDateOfPerformance() {
        return dateOfPerformance;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
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
