package com.example.dto.api;

public class AddDirectorToPerformanceDto {
    private int performanceId;
    private int directorId;

    public AddDirectorToPerformanceDto(int performanceId, int directorId) {
        this.performanceId = performanceId;
        this.directorId = directorId;
    }

    protected AddDirectorToPerformanceDto() {}

    public int getPerformanceId() {
        return performanceId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }
}
