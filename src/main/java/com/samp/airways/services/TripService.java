package com.samp.airways.services;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
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

    public Map<String, Object> getTrip(Long tripId){
        Optional<Trip> trip = tripRepo.findById(tripId);
        Map<String, Object> data = new HashMap<>();
        data.put("departure", trip.get().getDeparture().toString());
        data.put("arrival", trip.get().getArrival().toString());
        data.put("trip_id", trip.get().getId());
        data.put("source", trip.get().getSource().getCity());
        data.put("destination", trip.get().getDestination().getCity());
        data.put("flight_name", trip.get().getFlight().getFlight_name());
        data.put("fare", trip.get().getFlight().getFare());
        return data;
    }
    
    public List<Object> getTrips(String source, String destination, Date departure){

        List<Trip> trips = tripRepo.findBySourceAndDestinationAndDeparture(source, destination, departure);
        List<Object> res = new ArrayList<>();
        for(Trip trip : trips){
            Map<String, Object> data = new HashMap<>();
            data.put("departure", trip.getDeparture().toString());
            data.put("arrival", trip.getArrival().toString());
            data.put("trip_id", trip.getId());
            data.put("flight_id", trip.getFlight().getId());
            data.put("flight_name", trip.getFlight().getFlight_name());
            data.put("fare", trip.getFlight().getFare());
            res.add(data);
        }
        return res;
    }

}
