package com.example;

import com.example.dto.PerformanceDto;
import com.example.dto.api.*;
import com.example.entities.CategoryForWorker;
import com.example.services.ActorService;
import com.example.services.DirectorService;
import com.example.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ActorService actorService;
    @Autowired
    private PerformanceService performanceService;
    @Autowired
    private DirectorService directorService;

    @Override
    public void run(String... args) throws Exception {
        Date current = new Date();

        AddActorDto actorDto = new AddActorDto("Илья", "Иванов", "РУТ", "Золотая Малина", CategoryForWorker.FREE);
        actorService.add(actorDto);

        AddPerformanceDto addPerformanceDto = new AddPerformanceDto("Чайка", "2:30", current, "Борис Московский");
        performanceService.add(addPerformanceDto);
        AddActorToPerformanceDto addActorToPerformanceDto = new AddActorToPerformanceDto(1, 1, "Царевна");
        performanceService.addActorToPerformance(addActorToPerformanceDto);

        AddDirectorDto addDirectorDto = new AddDirectorDto("Иван", "Великий", "ГИТИС", "Розовый слон", CategoryForWorker.FREE);
        directorService.add(addDirectorDto);
        AddDirectorToPerformanceDto addDirectorToPerformanceDto = new AddDirectorToPerformanceDto(1, 1);
        performanceService.addDirectorToPerformance(addDirectorToPerformanceDto);
    }
}
