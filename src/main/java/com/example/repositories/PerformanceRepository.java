package com.example.repositories;

import com.example.entities.Performance;
import java.util.Optional;

public interface PerformanceRepository {
    Performance save(Performance performance);
    Optional<Performance> update(Performance performance);
    Optional<Performance> findByActorNameAndSurname (String name, String surname);
    Optional<Performance> findByDirectorNameAndSurname (String name, String surname);
}
