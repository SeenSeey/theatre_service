package com.example.dto.api;

public class AddPerformanceToTheatreDto {
    private int performanceId;
    private int theatreId;

    public AddPerformanceToTheatreDto(int performanceId, int theatreId) {
        this.performanceId = performanceId;
        this.theatreId = theatreId;
    }

    protected AddPerformanceToTheatreDto() {}

    public int getPerformanceId() {
        return performanceId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }
}

