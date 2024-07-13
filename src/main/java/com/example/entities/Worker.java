package com.example.entities;

import com.example.entities.BaseEntity;
import jakarta.persistence.*;

@MappedSuperclass
public class Worker extends BaseEntity {
    private String name;
    private String surname;
    private String education;
    private String award;

    public Worker(String name, String surname, String education, String award) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.award = award;
    }

    protected Worker() {}

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
}
