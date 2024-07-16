package com.example.controllers;

import com.example.dto.api.AddPerformanceToTheatreDto;
import com.example.dto.api.AddTheatreDto;
import com.example.dto.api.UpdateTheatreDto;
import com.example.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theaters")
public class TheatreRestController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/create")
    void create(@RequestBody AddTheatreDto addTheatreDto) {
        theatreService.add(addTheatreDto);
    }

    @PatchMapping("/update")
    void update(@RequestBody UpdateTheatreDto updateTheatreDto) {
        theatreService.update(updateTheatreDto);
    }

    @PatchMapping("/add-performance")
     void addPerformanceToTheatre(@RequestBody AddPerformanceToTheatreDto addPerformanceToTheatreDto) {
        theatreService.addPerformanceToTheatre(addPerformanceToTheatreDto);
     }
}
