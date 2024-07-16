package com.example.controllers;

import com.example.dto.ActorDto;
import com.example.dto.api.AddActorDto;
import com.example.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorRestController {
    @Autowired
    private ActorService actorService;

    @PostMapping
    public ActorDto create(@RequestBody AddActorDto addActorDto) {
        return actorService.add(addActorDto);
    }



}
