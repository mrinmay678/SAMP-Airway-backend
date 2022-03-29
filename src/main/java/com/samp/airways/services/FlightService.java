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

    public Flight saveFlight(Flight flight){
        return flightRepo.save(flight);
    }

    public Integer getCurrentCapactity(Flight flight){
        Optional<Flight> f = flightRepo.findById(flight.getId());
        return f.get().getCurrent_capacity();
    }
    public Integer getMaxCapactity(Flight flight){
        Optional<Flight> f = flightRepo.findById(flight.getId());
        return f.get().getMax_capacity();
    }

    public Flight updateCurrentCapacity(Flight flight){
        Optional<Flight> f = flightRepo.findById(flight.getId());
        f.get().setCurrent_capacity(f.get().getCurrent_capacity()+1);
        return flightRepo.save(f);
    }
}
