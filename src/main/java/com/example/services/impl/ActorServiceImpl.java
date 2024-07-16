package com.example.services.impl;

import com.example.dto.ActorDto;
import com.example.dto.api.AddActorDto;
import com.example.dto.api.UpdateActorDto;
import com.example.entities.Actor;
import com.example.repositories.ActorRepository;
import com.example.services.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public ActorDto add(AddActorDto addActorDto) {
        Actor actor = mapper.map(addActorDto, Actor.class);
        return mapper.map(actorRepository.save(actor), ActorDto.class);
    }

    @Override
    public Optional<ActorDto> update(UpdateActorDto actorDto) {
        return Optional.empty();
    }

    @Override
    public List<ActorDto> findActorByPerformanceName(String performanceName) {
        return actorRepository.findActorByPerformanceName(performanceName).stream().map((actor) -> mapper.map(actor, ActorDto.class)).toList();
    }
}
