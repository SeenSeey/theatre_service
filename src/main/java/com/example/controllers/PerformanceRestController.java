package com.example.controllers;

import com.example.dto.PerformanceDto;
import com.example.dto.api.AddActorToPerformanceDto;
import com.example.dto.api.AddDirectorToPerformanceDto;
import com.example.dto.api.AddPerformanceDto;
import com.example.dto.api.UpdatePerformanceDto;
import com.example.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performances")
public class PerformanceRestController {
    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/create")
    void create(@RequestBody AddPerformanceDto addPerformanceDto) {
        performanceService.add(addPerformanceDto);
    }

    @PatchMapping("/update")
    void update(@RequestBody UpdatePerformanceDto updatePerformanceDto) {
        performanceService.update(updatePerformanceDto);
    }

    @PatchMapping("/add-actor")
    void addActorToPerformance(@RequestBody AddActorToPerformanceDto addActorToPerformanceDto) {
        performanceService.addActorToPerformance(addActorToPerformanceDto);
    }

    @PatchMapping("/add-director")
    void addDirectorToPerformance(@RequestBody AddDirectorToPerformanceDto addDirectorToPerformanceDto) {
        performanceService.addDirectorToPerformance(addDirectorToPerformanceDto);
    }

    @PatchMapping("/update-category")
    void updateCategoriesAfterPerformance()  {
        performanceService.updateCategoriesAfterPerformance();
    }

    @GetMapping("/actor/{name}/{surname}")
    public List<PerformanceDto> findPerformanceByActorNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        return performanceService.findPerformanceByActorNameAndSurname(name, surname);
    }

    @GetMapping("/director/{name}/{surname}")
    public List<PerformanceDto> findPerformanceByDirectorNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        return performanceService.findPerformanceByDirectorNameAndSurname(name, surname);
    }
}
