package com.example;

import com.example.dto.api.AddActorDto;
import com.example.entities.CategoryForWorker;
import com.example.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ActorService actorService;

    @Override
    public void run(String... args) throws Exception {
        AddActorDto actorDto = new AddActorDto("Илья", "Иванов", "РУТ", "Золотая Малина", CategoryForWorker.FREE);
        actorService.add(actorDto);
    }
}
