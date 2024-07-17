package com.example.controllers;

import com.example.dto.ActorDto;
import com.example.dto.api.AddActorDto;
import com.example.dto.api.UpdateActorDto;
import com.example.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorRestController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/create")
    void create(@RequestBody AddActorDto addActorDto) {
        actorService.add(addActorDto);
    }

    @PatchMapping("/update")
    void update(@RequestBody UpdateActorDto updateActorDto) {
        actorService.update(updateActorDto);
    }

    @GetMapping("/{name}")
    public Iterable<ActorDto> findActorByPerformanceName(@PathVariable String name) {
        return actorService.findActorByPerformanceName(name);
    }
}
