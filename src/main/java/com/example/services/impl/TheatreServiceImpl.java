package com.example.services.impl;

import com.example.dto.TheatreDto;
import com.example.dto.api.AddTheatreDto;
import com.example.dto.api.UpdateTheatreDto;
import com.example.entities.Theatre;
import com.example.repositories.TheatreRepository;
import com.example.services.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public TheatreDto add(AddTheatreDto addTheatreDto) {
        Theatre theatre = mapper.map(addTheatreDto, Theatre.class);
        return mapper.map(theatreRepository.save(theatre), TheatreDto.class);
    }

    @Override
    public Optional<TheatreDto> update(UpdateTheatreDto updateTheatreDto) {
        Optional<Theatre> optionalTheatre = theatreRepository.findById(updateTheatreDto.getId());

        if (optionalTheatre.isPresent()) {
            Theatre theatre = optionalTheatre.get();
            mapper.map(updateTheatreDto, theatre);
            Theatre updatedTheatre = theatreRepository.save(theatre);
            return Optional.of(mapper.map(updatedTheatre, TheatreDto.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TheatreDto> findTheatreByPerformanceId(int id) {
        Optional<Theatre> optionalTheatre = theatreRepository.findTheatreByPerformanceId(id);

        if (optionalTheatre.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(mapper.map(optionalTheatre.get(), TheatreDto.class));
    }
}
