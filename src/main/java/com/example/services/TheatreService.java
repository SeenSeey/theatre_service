package com.example.services;

import com.example.dto.TheatreDto;
import com.example.dto.api.AddPerformanceToTheatreDto;
import com.example.dto.api.AddTheatreDto;
import com.example.dto.api.UpdateTheatreDto;

import java.util.Optional;

public interface TheatreService {
    TheatreDto add(AddTheatreDto addTheatreDto);
    Optional<TheatreDto> update(UpdateTheatreDto updateTheatreDto);
    Optional<TheatreDto> addPerformanceToTheatre(AddPerformanceToTheatreDto addPerformanceToTheatreDto);
}
