package com.example.services;

import com.example.dto.PerformanceDto;
import com.example.dto.api.AddActorToPerformanceDto;
import com.example.dto.api.AddPerformanceDto;
import com.example.dto.api.UpdatePerformanceDto;
import com.example.entities.Performance;

import java.util.List;
import java.util.Optional;

public interface PerformanceService {
    PerformanceDto add(AddPerformanceDto addPerformanceDto);
    Optional<PerformanceDto> update(UpdatePerformanceDto updatePerformanceDto);
    List<PerformanceDto> findPerformanceByActorNameAndSurname (String name, String surname);
    List<PerformanceDto> findPerformanceByDirectorNameAndSurname (String name, String surname);
    Optional<PerformanceDto> addActorToPerformance(AddActorToPerformanceDto addActorToPerformanceDto);

    void updateActorCategoriesAfterPerformance();
}
