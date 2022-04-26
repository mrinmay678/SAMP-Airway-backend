package com.samp.airways.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.samp.airways.models.Flight;
import com.samp.airways.repositories.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class FlightService{

    @Autowired
    private FlightRepository flightRepo;

    public void saveFlight(Flight flight){
        flightRepo.save(flight);
    }

    public Integer getCurrentCapactity(Long flight){
        Optional<Flight> f = flightRepo.findById(flight);
        return f.get().getCurrent_capacity();
    }
    public Integer getMaxCapactity(Long flight){
        Optional<Flight> f = flightRepo.findById(flight);
        return f.get().getMax_capacity();
    }

    public void updateCurrentCapacity(Long flight){
        Flight f = flightRepo.findById(flight).get();
        f.setCurrent_capacity(f.getCurrent_capacity()+1);
        flightRepo.save(f);
    }
}
