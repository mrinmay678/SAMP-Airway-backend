package com.samp.airways.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.samp.airways.models.Trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Optional<Trip> findById(Long id);

    List<Trip> findBySourceAndDestinationAndDeparture(String source, String destination, Date departure);
}
