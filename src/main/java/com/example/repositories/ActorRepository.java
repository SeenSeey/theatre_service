package com.example.repositories;

import com.example.entities.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends CrudRepository<Actor, Integer>{
    @Query(value = "SELECT a FROM Actor a JOIN a.contract c " +
            "JOIN c.performance p WHERE p.name = :performanceName")
    List<Actor> findActorByPerformanceName(@Param("performanceName") String performanceName);

    @Query(value = "SELECT a FROM Actor a WHERE a.id = :id")
    Optional<Actor> findById(@Param("id") int id);
}
