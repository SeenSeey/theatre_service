package com.example.repositories.impl;

import com.example.entities.Theatre;
import com.example.repositories.TheatreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TheatreRepositoryImpl implements TheatreRepository {
    @PersistenceContext
    EntityManager entityManager;
    TheatreRepository theatreRepository;

    @Override
    public Theatre save(Theatre theatre) {
        entityManager.persist(theatre);
        return theatre;
    }

    @Override
    public Optional<Theatre> update(Theatre theatre) {
        return Optional.of(entityManager.merge(theatre));
    }

    @Override
    public Optional<Theatre> findById(int id) {
        return theatreRepository.findById(id);
    }

    @Override
    public Theatre findTheatreByPerformanceId(int id) {
        return theatreRepository.findTheatreByPerformanceId(id);
    }
}
