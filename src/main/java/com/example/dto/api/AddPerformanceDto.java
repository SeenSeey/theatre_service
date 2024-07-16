package com.example.dto.api;

import java.util.Date;

public class AddPerformanceDto {
    private String name;
    private String timeIntervalPerformance;
    private Date dateOfPerformance;
    private String author;

    public AddPerformanceDto(String name, String timeIntervalPerformance, Date dateOfPerformance, String author) {
        this.name = name;
        this.timeIntervalPerformance = timeIntervalPerformance;
        this.dateOfPerformance = dateOfPerformance;
        this.author = author;
    }

    protected AddPerformanceDto() {}

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
