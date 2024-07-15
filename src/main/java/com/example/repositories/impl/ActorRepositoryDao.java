package com.example.repositories.impl;

import com.example.entities.Actor;
import com.example.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepositoryDao implements ActorRepository {
    @Autowired
    private BaseActorRepository baseActorRepository;

    @Override
    public Actor save(Actor actor) {
        return baseActorRepository.save(actor);
    }

    @Override
    public Optional<Actor> update(Actor actor) {
        return Optional.of(baseActorRepository.save(actor));
    }

    @Override
    public List<Actor> findActorByPerformanceName(String performanceName) {
        return baseActorRepository.findActorByPerformanceName(performanceName);
    }
}

@Repository
interface BaseActorRepository extends JpaRepository<Actor, Integer> {
    @Query(value = "select a FROM Actor a " + "JOIN a.contracts c " +
            "JOIN c.performance p " + "WHERE p.name = :performanceName")
    List<Actor> findActorByPerformanceName(@Param("performanceName") String performanceName);
}