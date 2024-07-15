package com.example.repositories;

import com.example.entities.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorRepository {
    Actor save(Actor actor);
    Optional<Actor> update(Actor actor);
    List<Actor> findActorByPerformanceName(String performanceName);
}
