package com.example.repositories;

import com.example.entities.Performance;

import java.util.List;
import java.util.Optional;

public interface PerformanceRepository {
    Performance save(Performance performance);
    Optional<Performance> update(Performance performance);
    List<Performance> findPerformanceByActorNameAndSurname (String name, String surname);
    List<Performance> findPerformanceByDirectorNameAndSurname (String name, String surname);
    Optional<Performance> findById(int id);
}
