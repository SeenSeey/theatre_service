package com.example.dto;

public class ContractDto {
    private int id;
    private String role;

    public ContractDto(int id, String role) {
        this.id = id;
        this.role = role;
    }

    protected ContractDto() {}

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
