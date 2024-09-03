package com.example.repositories;

import com.example.entities.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends CrudRepository<Director, Integer>{
//    Director save(Director director);
//    Optional<Director> update(Director director);
//    List<Director> findDirectorByPerformanceName(String performanceName);
//    Optional<Director> findById(int id);
    @Query(value = "SELECT d FROM Director d JOIN d.performance p WHERE p.name = :performanceName")
    List<Director> findDirectorByPerformanceName(@Param("performanceName") String name);

    @Query(value = "SELECT d FROM Director d WHERE d.id = :id")
    Optional<Director> findById(@Param("id") int id);
}
