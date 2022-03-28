package com.samp.airways.repositories;

import java.util.List;
import java.util.Optional;

import com.samp.airways.models.Booking;
import com.samp.airways.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findById(Long id);
    List<Booking> findByUserid(Long userid);
}
