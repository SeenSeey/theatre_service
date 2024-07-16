package com.example.controllers;

import com.example.dto.DirectorDto;
import com.example.dto.api.AddDirectorDto;
import com.example.dto.api.UpdateDirectorDto;
import com.example.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorRestController {
    @Autowired
    private DirectorService directorService;

    @PostMapping("/create")
    void create(@RequestBody AddDirectorDto addDirectorDto) {
        directorService.add(addDirectorDto);
    }

    @PatchMapping("/update")
    void update(@RequestBody UpdateDirectorDto updateDirectorDto) {
        directorService.update(updateDirectorDto);
    }

    @GetMapping("/{name}")
    public Iterable<DirectorDto> findDirectorByPerformanceName(@PathVariable String name) {
        return directorService.findDirectorByPerformanceName(name);
    }
}
