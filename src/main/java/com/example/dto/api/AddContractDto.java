package com.example.dto.api;

public class AddContractDto {
    private String role;

    public AddContractDto(String role) {
        this.role = role;
    }

    protected AddContractDto() {}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
