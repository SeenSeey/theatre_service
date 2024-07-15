package com.example.repositories.impl;

import com.example.entities.Theatre;
import com.example.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TheatreRepositoryDao implements TheatreRepository {
    @Autowired
    private BaseTheatreRepository baseTheatreRepository;

    @Override
    public Theatre save(Theatre theatre) {
        return baseTheatreRepository.save(theatre);
    }

    @Override
    public Optional<Theatre> update(Theatre theatre) {
        return Optional.of(baseTheatreRepository.save(theatre));
    }

    @Override
    public Optional<Theatre> findTheatreByPerformanceId(int id) {
        return Optional.of(baseTheatreRepository.findTheatreByPerformanceId(id));
    }
}

@Repository
interface BaseTheatreRepository extends JpaRepository<Theatre, Integer> {
    @Query(value = "SELECT t FROM Theatre t JOIN t.performance p WHERE p.id = :id")
    Theatre findTheatreByPerformanceId(@Param("id") int id);
}