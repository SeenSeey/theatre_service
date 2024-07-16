package com.example.services.impl;

import com.example.dto.PerformanceDto;
import com.example.dto.api.AddPerformanceDto;
import com.example.dto.api.UpdatePerformanceDto;
import com.example.entities.Performance;
import com.example.repositories.PerformanceRepository;
import com.example.services.PerformanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public PerformanceDto add(AddPerformanceDto addPerformanceDto) {
        Performance performance = mapper.map(addPerformanceDto, Performance.class);
        return mapper.map(performanceRepository.save(performance), PerformanceDto.class);
    }

    @Override
    public Optional<PerformanceDto> update(UpdatePerformanceDto updatePerformanceDto) {
        Optional<Performance> optionalPerformance = performanceRepository.findById(updatePerformanceDto.getId());

        if (optionalPerformance.isPresent()) {
            Performance performance = optionalPerformance.get();
            mapper.map(updatePerformanceDto, performance);
            Performance updatedPerformance = performanceRepository.save(performance);
            return Optional.of(mapper.map(updatedPerformance, PerformanceDto.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<PerformanceDto> findPerformanceByActorNameAndSurname(String name, String surname) {
        return performanceRepository.findPerformanceByActorNameAndSurname(name, surname).stream().map((performance) ->
                mapper.map(performance, PerformanceDto.class)).toList();
    }

    @Override
    public List<PerformanceDto> findPerformanceByDirectorNameAndSurname(String name, String surname) {
        return performanceRepository.findPerformanceByDirectorNameAndSurname(name, surname).stream().map((performance) ->
                mapper.map(performance, PerformanceDto.class)).toList();
    }
}
