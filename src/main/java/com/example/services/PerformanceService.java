package com.example.services;

import com.example.dto.PerformanceDto;
import com.example.dto.api.*;

import java.util.List;
import java.util.Optional;

public interface PerformanceService {
    PerformanceDto add(AddPerformanceDto addPerformanceDto);
    Optional<PerformanceDto> update(UpdatePerformanceDto updatePerformanceDto);
    List<PerformanceDto> findPerformanceByActorNameAndSurname (String name, String surname);
    List<PerformanceDto> findPerformanceByDirectorNameAndSurname (String name, String surname);
    void updateCategoriesAfterPerformance();
    void addActorToPerformance(AddActorToPerformanceDto addActorToPerformanceDto);
    void addDirectorToPerformance(AddDirectorToPerformanceDto addDirectorToPerformanceDto);
}

