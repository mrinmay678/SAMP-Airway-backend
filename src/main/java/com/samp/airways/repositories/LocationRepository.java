package com.samp.airways.repositories;

import com.samp.airways.models.Location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {
    
}
