package com.example.services.impl;

import com.example.dto.PerformanceDto;
import com.example.dto.api.*;
import com.example.entities.*;
import com.example.repositories.ActorRepository;
import com.example.repositories.DirectorRepository;
import com.example.repositories.PerformanceRepository;
import com.example.repositories.TheatreRepository;
import com.example.services.PerformanceService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private TheatreRepository theatreRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public PerformanceDto add(AddPerformanceDto addPerformanceDto) {
        Performance performance = mapper.map(addPerformanceDto, Performance.class);
        return mapper.map(performanceRepository.save(performance), PerformanceDto.class);
    }

    @Override
    public Optional<PerformanceDto> update(UpdatePerformanceDto updatePerformanceDto) {
        Optional<Performance> optionalPerformance = performanceRepository.findById(updatePerformanceDto.getId());

        if (optionalPerformance.isPresent()) {
            Performance performance = optionalPerformance.get();
            mapper.map(updatePerformanceDto, performance);
            Performance updatedPerformance = performanceRepository.save(performance);
            return Optional.of(mapper.map(updatedPerformance, PerformanceDto.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<PerformanceDto> findPerformanceByActorNameAndSurname(String name, String surname) {
        Date currentDate = new Date();
        return performanceRepository.findPerformanceByActorNameAndSurname(name, surname).stream()
                .filter(performance -> performance.getDateOfPerformance().after(currentDate))
                .map(performance -> mapper.map(performance, PerformanceDto.class))
                .toList();
    }

    @Override
    public List<PerformanceDto> findPerformanceByDirectorNameAndSurname(String name, String surname) {
        Date currentDate = new Date();
        return performanceRepository.findPerformanceByDirectorNameAndSurname(name, surname).stream()
                .filter(performance -> performance.getDateOfPerformance().after(currentDate))
                .map(performance -> mapper.map(performance, PerformanceDto.class))
                .toList();
    }

    @Override
    public void updateCategoriesAfterPerformance() {
        List<Performance> performances = performanceRepository.findAll();
        Date currentDate = new Date();

        for (Performance performance : performances) {
            Date dateOfPerformance = performance.getDateOfPerformance();
            if (dateOfPerformance != null && dateOfPerformance.before(currentDate)) {
                for (Contract contract : performance.getContract()) {
                    Actor actor = contract.getActor();
                    actor.setCategory(CategoryForWorker.FREE);
                    actorRepository.save(actor);
                }

                for (Director director : performance.getDirector()) {
                    director.setCategory(CategoryForWorker.FREE);
                    directorRepository.save(director);
                }
            }
        }
    }

    @Override
    @Transactional
    public Optional<PerformanceDto> addActorToPerformance(AddActorToPerformanceDto addActorToPerformanceDto) {
        updateCategoriesAfterPerformance();
        Optional<Performance> optionalPerformance = performanceRepository.findById(addActorToPerformanceDto.getPerformanceId());
        Optional<Actor> optionalActor = actorRepository.findById(addActorToPerformanceDto.getActorId());

        if (optionalPerformance.isPresent() && optionalActor.isPresent()) {
            Performance performance = optionalPerformance.get();
            Actor actor = optionalActor.get();

            if (actor.getCategory() == CategoryForWorker.FREE) {
                Contract contract = new Contract(performance, actor, addActorToPerformanceDto.getRole());
                performance.getContract().add(contract);

                actor.setCategory(CategoryForWorker.BUSY);

                performanceRepository.save(performance);
                actorRepository.save(actor);
                return Optional.of(mapper.map(performance, PerformanceDto.class));
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<PerformanceDto> addDirectorToPerformance(AddDirectorToPerformanceDto addDirectorToPerformanceDto) {
        updateCategoriesAfterPerformance();
        Optional<Performance> optionalPerformance = performanceRepository.findById(addDirectorToPerformanceDto.getPerformanceId());
        Optional<Director> optionalDirector = directorRepository.findById(addDirectorToPerformanceDto.getDirectorId());

        if (optionalPerformance.isPresent() && optionalDirector.isPresent()) {
            Performance performance = optionalPerformance.get();
            Director director = optionalDirector.get();

            if (director.getCategory() == CategoryForWorker.FREE) {
                performance.getDirector().add(director);
                director.getPerformance().add(performance);

                director.setCategory(CategoryForWorker.BUSY);

                performanceRepository.save(performance);
                directorRepository.save(director);
                return Optional.of(mapper.map(performance, PerformanceDto.class));
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }
}
