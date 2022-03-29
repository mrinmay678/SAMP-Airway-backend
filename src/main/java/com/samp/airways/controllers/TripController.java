package com.samp.airways.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.Location;
import com.samp.airways.response.Response;
import com.samp.airways.services.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {
    
    @Autowired
    private TripService tripService;

    @Autowired
    private Response res;
    
    @RequestMapping("/public/flights/search")
    public ResponseEntity<Object> getFlights(@RequestParam Location source, @RequestParam Location destination, @RequestParam Date date) {
        try{
            Map<String, Object> data = new HashMap<>();
            data.put("trips", tripService.getTrips(source, destination, date));
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
    
    @RequestMapping("/public/flight")
    public ResponseEntity<Object> getFlightDetail(@RequestParam Long id) {
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
