package com.example.dto.api;

public class AddActorToPerformanceDto {
    private int performanceId;
    private int actorId;
    private String role;

    public AddActorToPerformanceDto(int performanceId, int actorId, String role) {
        this.performanceId = performanceId;
        this.actorId = actorId;
        this.role = role;
    }

    protected AddActorToPerformanceDto() {}

    public int getPerformanceId() {
        return performanceId;
    }

    public int getActorId() {
        return actorId;
    }

    public String getRole() {
        return role;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
