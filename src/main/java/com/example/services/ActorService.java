package com.example.services;

import com.example.dto.ActorDto;
import com.example.dto.api.AddActorDto;
import com.example.dto.api.UpdateActorDto;
import com.example.entities.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    ActorDto add(AddActorDto addActorDto);
    Optional<ActorDto> update(UpdateActorDto updateActorDto);
    List<ActorDto> findActorByPerformanceName(String performanceName);
}
