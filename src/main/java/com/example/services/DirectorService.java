package com.example.services;

import com.example.dto.DirectorDto;
import com.example.dto.api.AddDirectorDto;
import com.example.dto.api.UpdateDirectorDto;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    DirectorDto add(AddDirectorDto addDirectorDto);
    Optional<DirectorDto> update(UpdateDirectorDto updateDirectorDto);
    List<DirectorDto> findDirectorByPerformanceName(String performanceName);
}
