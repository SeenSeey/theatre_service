package com.example.repositories.impl;

import com.example.entities.Actor;
import com.example.repositories.ActorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepositoryImpl implements ActorRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private ActorRepository actorRepository;

    @Override
    public Actor save(Actor actor) {
        entityManager.persist(actor);
        return actor;
    }

    @Override
    public Optional<Actor> update(Actor actor) {
        return Optional.of(entityManager.merge(actor));
    }

    @Override
    public List<Actor> findActorByPerformanceName(String performanceName) {
        return actorRepository.findActorByPerformanceName(performanceName);
    }

    @Override
    public Optional<Actor> findById(int id) {
        return actorRepository.findById(id);
    }
}
