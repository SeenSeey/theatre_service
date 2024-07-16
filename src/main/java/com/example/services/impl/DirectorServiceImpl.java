package com.example.services.impl;

import com.example.dto.DirectorDto;
import com.example.dto.api.AddDirectorDto;
import com.example.dto.api.UpdateDirectorDto;
import com.example.entities.Director;
import com.example.repositories.DirectorRepository;
import com.example.services.DirectorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public DirectorDto add(AddDirectorDto addDirectorDto) {
        Director director = mapper.map(addDirectorDto, Director.class);
        return mapper.map(directorRepository.save(director), DirectorDto.class);
    }

    @Override
    public Optional<DirectorDto> update(UpdateDirectorDto updateDirectorDto) {
        Optional<Director> optionalDirector = directorRepository.findById(updateDirectorDto.getId());

        if (optionalDirector.isPresent()) {
            Director director = optionalDirector.get();
            mapper.map(updateDirectorDto, director);
            Director updatedDirector = directorRepository.save(director);
            return Optional.of(mapper.map(updatedDirector, DirectorDto.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<DirectorDto> findDirectorByPerformanceName(String performanceName) {
        return directorRepository.findDirectorByPerformanceName(performanceName).stream().map((director) ->
                mapper.map(director, DirectorDto.class)).toList();
    }
}
