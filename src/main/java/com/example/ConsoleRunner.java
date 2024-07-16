package com.example;

import com.example.dto.PerformanceDto;
import com.example.dto.api.AddActorDto;
import com.example.dto.api.AddActorToPerformanceDto;
import com.example.dto.api.AddPerformanceDto;
import com.example.entities.CategoryForWorker;
import com.example.services.ActorService;
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

    @Override
    public void run(String... args) throws Exception {
        Date current = new Date();

        AddActorDto actorDto = new AddActorDto("Илья", "Иванов", "РУТ", "Золотая Малина", CategoryForWorker.FREE);
        actorService.add(actorDto);
        AddPerformanceDto addPerformanceDto = new AddPerformanceDto("Чайка", "2:30", current, "Борис Московский");
        performanceService.add(addPerformanceDto);
        AddActorToPerformanceDto addActorToPerformanceDto = new AddActorToPerformanceDto(1, 1, "Царевна");
        performanceService.addActorToPerformance(addActorToPerformanceDto);

        performanceService.findPerformanceByActorNameAndSurname("Илья", "Иванов");
    }
}
