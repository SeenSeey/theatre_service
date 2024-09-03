package com.example.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T, Integer> extends BaseRepository<T, Integer>{
    Optional<T> update(T object);
//    Optional<T> findById(Class<T> object, int id);
}
