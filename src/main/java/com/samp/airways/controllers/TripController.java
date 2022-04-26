package com.samp.airways.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.Location;
import com.samp.airways.services.TripService;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samp.airways.response.Response;

@RestController
public class TripController {
    
    @Autowired
    private TripService tripService;
    
    @GetMapping("/public/flights/search")
    public ResponseEntity<Object> getFlights(@RequestParam String source, @RequestParam String destination, @RequestParam String departure_date) {
        Response res = new Response();
        try{
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
            Date departure=formatter.parse(departure_date);
            Map<String, Object> data = new HashMap<>();
            System.out.println(tripService.getTrips(source, destination, departure));
            data.put("trips", tripService.getTrips(source, destination, departure));
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
    
    @GetMapping("/public/flight")
    public ResponseEntity<Object> getFlightDetail(@RequestParam Long id) {
        Response res = new Response();
        try{
            Map<String, Object> data = new HashMap<>();
            data.put("trip", tripService.getTrip(id));
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }

}
