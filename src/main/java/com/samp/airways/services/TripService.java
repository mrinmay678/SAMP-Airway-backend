package com.samp.airways.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.samp.airways.models.Location;
import com.samp.airways.models.Trip;
import com.samp.airways.repositories.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class TripService {

    @Autowired
    private TripRepository tripRepo;

    public Trip saveTrip(Trip trip){
        return tripRepo.save(trip);
    }

    public Optional<Trip> getTrip(Long tripId){
        return tripRepo.findById(tripId);
    }
    
    public List<Trip> getTrips(Location source, Location destination, Date departure){
        return tripRepo.findBySourceAndDestinationAndDeparture(source.getId(), destination.getId(), departure);
    }

}
