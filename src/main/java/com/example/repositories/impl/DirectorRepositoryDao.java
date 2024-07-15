package com.example.repositories.impl;

import com.example.entities.Director;
import com.example.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DirectorRepositoryDao implements DirectorRepository {
    @Autowired
    private BaseDirectorRepository baseDirectorRepository;

    @Override
    public Director save(Director director) {
        return baseDirectorRepository.save(director);
    }

    @Override
    public Optional<Director> update(Director director) {
        return Optional.of(baseDirectorRepository.save(director));
    }

    @Override
    public List<Director> findDirectorByPerformanceName(String performanceName) {
        return baseDirectorRepository.findDirectorByPerformanceName(performanceName);
    }
}

@Repository
interface BaseDirectorRepository extends JpaRepository<Director, Integer> {
    @Query(value = "SELECT d FROM Director d JOIN d.performance p WHERE p.name = :performanceName")
    List<Director> findDirectorByPerformanceName(@Param("performanceName") String name);
}