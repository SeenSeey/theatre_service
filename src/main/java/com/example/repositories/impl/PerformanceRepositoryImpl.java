package com.example.repositories.impl;

import com.example.entities.Performance;
import com.example.repositories.PerformanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerformanceRepositoryImpl implements PerformanceRepository {
    @PersistenceContext
    EntityManager entityManager;
    PerformanceRepository performanceRepository;

    @Override
    public Performance save(Performance performance) {
        entityManager.persist(performance);
        return performance;
    }

    @Override
    public Optional<Performance> update(Performance performance) {
        return Optional.of(entityManager.merge(performance));
    }

    @Override
    public Optional<Performance> findById(int id) {
        return performanceRepository.findById(id);
    }

    @Override
    public List<Performance> findPerformanceByActorNameAndSurname(String name, String surname) {
        return performanceRepository.findPerformanceByActorNameAndSurname(name, surname);
    }

    @Override
    public List<Performance> findPerformanceByDirectorNameAndSurname(String name, String surname) {
        return performanceRepository.findPerformanceByDirectorNameAndSurname(name, surname);
    }

    @Override
    public List<Performance> findAll() {
        return null;
    }
}
