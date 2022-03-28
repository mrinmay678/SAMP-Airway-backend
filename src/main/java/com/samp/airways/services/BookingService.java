package com.samp.airways.services;

import java.util.List;

import javax.transaction.Transactional;

import com.samp.airways.models.Booking;
import com.samp.airways.models.User;
import com.samp.airways.repositories.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service @Transactional
public class BookingService{

    @Autowired
    private BookingRepository bookingRepo;

    public Booking saveBooking(Booking booking){
        return bookingRepo.save(booking);
    }

    public Booking getBooking(Long bookingId){
        return bookingRepo.findById(bookingId).get();
    }

    public List<Booking> getBookings(User user){
        return bookingRepo.findByUserid(user.getId());
    }


}
