package com.example.repositories;

import com.example.entities.Performance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerformanceRepository extends CrudRepository<Performance, Integer> {
    @Query("SELECT p FROM Performance p JOIN p.contract c JOIN c.actor a WHERE a.name = :name AND a.surname = :surname")
    List<Performance> findPerformanceByActorNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query(value = "SELECT p FROM Performance p JOIN p.director d WHERE d.name = :name AND d.surname = :surname")
    List<Performance> findPerformanceByDirectorNameAndSurname(@Param("name") String name,
                                                              @Param("surname") String surname);

    @Query(value = "SELECT p FROM Performance p")
    List<Performance> findAll();

    @Query(value = "SELECT p FROM Performance p WHERE p.id = :id")
    Optional<Performance> findById(@Param("id") int id);
}
