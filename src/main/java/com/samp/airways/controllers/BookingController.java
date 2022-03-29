package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.Booking;
import com.samp.airways.response.Response;
import com.samp.airways.services.BookingService;
import com.samp.airways.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightService flightService;
    
    @Autowired
    private Response res;
    
    @PostMapping("/book")
    public ResponseEntity<Object> bookTicket(Booking booking) {
        try{
            Map<String, Object> data = new HashMap<>();
            Integer mc = flightService.getCurrentCapactity(booking.getFlight()); // get max capacity
            Integer cc = flightService.getMaxCapactity(booking.getFlight()); // get current capacity
            flightService.updateCurrentCapacity(booking.getFlight()); // update current capacity
            if(cc < mc){
                bookingService.saveBooking(booking);
                data.put("confirmed", true);
            }
            else {
                data.put("confirmed", false);
            }
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
