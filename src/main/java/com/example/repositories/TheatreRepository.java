package com.example.repositories;

import com.example.entities.Theatre;

import java.util.Optional;

public interface TheatreRepository {
    Theatre save(Theatre theatre);
    Optional<Theatre> update(Theatre theatre);
    Optional<Theatre> findTheatreByPerformanceId(int id);
    Optional<Theatre> findById(int id);
}
