package com.example.repositories.impl;

import com.example.entities.Performance;
import com.example.repositories.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerformanceRepositoryDao implements PerformanceRepository {
    @Autowired
    private BasePerformanceRepository basePerformanceRepository;

    @Override
    public Performance save(Performance performance) {
        return basePerformanceRepository.save(performance);
    }

    @Override
    public Optional<Performance> update(Performance performance) {
        return Optional.of(basePerformanceRepository.save(performance));
    }

    @Override
    public List<Performance> findPerformanceByActorNameAndSurname(String name, String surname) {
        return basePerformanceRepository.findPerformanceByActorNameAndSurname(name, surname);
    }

    @Override
    public List<Performance> findPerformanceByDirectorNameAndSurname(String name, String surname) {
        return basePerformanceRepository.findPerformanceByDirectorNameAndSurname(name, surname);
    }

    @Override
    public Optional<Performance> findById(int id) {
        return Optional.of(basePerformanceRepository.findById(id));
    }
}

@Repository
interface BasePerformanceRepository extends JpaRepository<Performance, Integer> {
    @Query(value = "SELECT p FROM Performance p JOIN p.contract c JOIN c.actor a " +
            "WHERE a.name = :name AND a.surname = :surname")
    List<Performance> findPerformanceByActorNameAndSurname(@Param("name") String name,
                                                           @Param("surname") String surname);

    @Query(value = "SELECT p FROM Performance p JOIN p.director d WHERE d.name = :name AND d.surname = :surname")
    List<Performance> findPerformanceByDirectorNameAndSurname(@Param("name") String name,
                                                              @Param("surname") String surname);

    @Query(value = "SELECT p FROM Performance p WHERE p.id = :id")
    Performance findById(@Param("id") int id);
}