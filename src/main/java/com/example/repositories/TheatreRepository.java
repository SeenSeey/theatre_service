package com.example.repositories;

import com.example.entities.Theatre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TheatreRepository extends CrudRepository<Theatre, Integer> {
    @Query(value = "SELECT t FROM Theatre t JOIN t.performance p WHERE p.id = :id")
    Theatre findTheatreByPerformanceId(@Param("id") int id);

    @Query(value = "SELECT t FROM Theatre t WHERE t.id = :id")
    Optional<Theatre> findById(@Param("id") int id);
}
