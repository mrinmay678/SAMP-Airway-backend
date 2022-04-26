package com.samp.airways.repositories;

import java.util.List;
import java.util.Optional;

import com.samp.airways.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findById(Long id);
    List<Booking> findByUserid(Long userid);
}
