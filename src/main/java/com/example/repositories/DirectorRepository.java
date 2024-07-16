package com.example.repositories;

import com.example.entities.Actor;
import com.example.entities.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository {
    Director save(Director director);
    Optional<Director> update(Director director);
    List<Director> findDirectorByPerformanceName(String performanceName);
    Optional<Director> findById(int id);
}
