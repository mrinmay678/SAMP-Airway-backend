package com.samp.airways.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

import com.samp.airways.models.Trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripRepository extends JpaRepository<Trip, Serializable> {
    Optional<Trip> findById(Long id);

    List<Trip> findBySourceAndDestinationAndDeparture(String source, String destination, Date departure);
}
