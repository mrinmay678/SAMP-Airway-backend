package com.samp.airways.services;

import java.util.*;

import javax.transaction.Transactional;

import com.samp.airways.models.*;
import com.samp.airways.repositories.*;
import com.samp.airways.requests.BookingRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service @Transactional
public class BookingService{

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PassengerRepository passengerRepo;

    @Autowired
    private TripRepository tripRepo;

    @Autowired
    private FlightRepository flightRepo;

    public void saveBooking(BookingRequest booking){
        try {
            Booking b = new Booking(
                userRepo.findByUsername(booking.getUsername()).get(),
                tripRepo.findById(booking.getTrip()).get(),
                flightRepo.findById(booking.getFlight()).get(),
                booking.getTotal_fare()
            );
            
            bookingRepo.save(b);

            try {
                System.out.println("Id"+b.getId());
            }
            catch (Exception e) {
                System.out.println("Id"+e.getMessage());
            }

            for(HashMap p : booking.getPassengers()){

                try {
                    System.out.println(p.get("first_name").toString());
                    System.out.println(p.get("last_name").toString());
                    System.out.println(p.get("email").toString());
                    System.out.println(p.get("phone").toString());
                    System.out.println(Integer.parseInt(p.get("age").toString()));
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                Passenger passenger = new Passenger(
                    p.get("first_name").toString(),
                    p.get("last_name").toString(),
                    p.get("email").toString(),
                    p.get("phone").toString(),
                    Integer.parseInt(p.get("age").toString()),
                    b.getId()
                );
    
                passengerRepo.save(passenger);
            }
    
        }
        catch(Exception err){
            try {
                System.out.println(booking.getUsername());
            }
            catch (Exception e) {
                System.out.println("No username");
            }
            try {
                System.out.println(booking.getTrip());
            }
            catch (Exception e) {
                System.out.println("No trip");
            }
            try {
                System.out.println(booking.getFlight());
            }
            catch (Exception e) {
                System.out.println("No Flight");
            }
            try {
                System.out.println(booking.getTotal_fare());
            }
            catch (Exception e) {
                System.out.println("No Total Fare");
            }
            System.out.println(err.getMessage());
        }
        
    }

    public Booking getBooking(Long bookingId){
        return bookingRepo.findById(bookingId).get();
    }

    public List<Booking> getBookings(AppUser user){
        return bookingRepo.findByUserid(user.getId());
    }


}
