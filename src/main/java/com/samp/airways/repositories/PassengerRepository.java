package com.samp.airways.repositories;

import java.util.Optional;

import com.samp.airways.models.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    
}
