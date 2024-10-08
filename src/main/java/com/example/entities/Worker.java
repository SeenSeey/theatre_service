package com.example.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Worker extends BaseEntity {
    private String name;
    private String surname;
    private String education;
    private String award;
    private CategoryForWorker category;

    public Worker(String name, String surname, String education, String award, CategoryForWorker category) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.award = award;
        this.category = category;
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

    @Column(name = "category", nullable = false)
    public CategoryForWorker getCategory() {
        return category;
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

    public void setCategory(CategoryForWorker category) {
        this.category = category;
    }
}
