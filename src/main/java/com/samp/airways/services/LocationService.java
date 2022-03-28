package com.samp.airways.services;

import java.util.List;

import javax.transaction.Transactional;

import com.samp.airways.models.Location;
import com.samp.airways.repositories.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class LocationService {

    @Autowired
    private LocationRepository locationRepo;

    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }
}
