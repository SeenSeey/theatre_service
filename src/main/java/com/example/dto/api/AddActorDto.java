package com.example.dto.api;

import com.example.entities.CategoryForWorker;

public class AddActorDto {
    private String name;
    private String surname;
    private String education;
    private String award;
    private CategoryForWorker category;

    public AddActorDto(String name, String surname, String education, String award, CategoryForWorker category) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.award = award;
        this.category = category;
    }

    protected AddActorDto() {}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getAward() {
        return award;
    }

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

