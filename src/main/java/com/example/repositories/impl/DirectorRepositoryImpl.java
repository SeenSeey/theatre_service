package com.example.repositories.impl;

import com.example.entities.Director;
import com.example.repositories.DirectorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DirectorRepositoryImpl implements DirectorRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private DirectorRepository directorRepository;

    @Override
    public Director save(Director director) {
        entityManager.persist(director);
        return director;
    }

    @Override
    public Optional<Director> update(Director director) {
        return Optional.of(entityManager.merge(director));
    }

    @Override
    public Optional<Director> findById(int id) {
        return directorRepository.findById(id);
    }

    @Override
    public List<Director> findDirectorByPerformanceName(String performanceName) {
        return directorRepository.findDirectorByPerformanceName(performanceName);
    }
}