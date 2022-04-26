package com.samp.airways.repositories;

import java.util.Optional;

import com.samp.airways.models.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findById(Long id);
}
