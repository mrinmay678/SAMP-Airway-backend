package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.Booking;
import com.samp.airways.response.Response;
import com.samp.airways.requests.BookingRequest;
import com.samp.airways.services.BookingService;
import com.samp.airways.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightService flightService;
    
    @PostMapping("/book")
    public ResponseEntity<Object> bookTicket(@RequestBody BookingRequest booking) {
        Response res = new Response();
        Map<String, Object> data = new HashMap<>();
        Integer cc = flightService.getCurrentCapactity(booking.getFlight()); // get max capacity
        Integer mc = flightService.getMaxCapactity(booking.getFlight()); // get current capacity
        flightService.updateCurrentCapacity(booking.getFlight()); // update current capacity
        if(cc < mc) {
            bookingService.saveBooking(booking);
            data.put("confirmed", true);
        }
        else {
            data.put("confirmed", false);
            data.put("message", "Sorry, this flight is full");
        }
        return res.get(data, HttpStatus.OK);
        
    }
}
