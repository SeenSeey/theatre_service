package com.example.repositories;

import com.example.entities.Director;
import java.util.Optional;

public interface DirectorRepository {
    Director save(Director director);
    Optional<Director> update(Director director);
//    Optional<Director> findByNameAndSurname(String name, String surname);
    Optional<Director> findByPerformanceName(String name);
}
