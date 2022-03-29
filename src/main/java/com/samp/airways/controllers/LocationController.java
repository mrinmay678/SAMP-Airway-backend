package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.response.Response;
import com.samp.airways.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private Response res;
    
    @RequestMapping("/public/location")
    public ResponseEntity<Object> getLocation() {
        try{
            Map<String, Object> data = new HashMap<>();
            data.put("location", locationService.getAllLocations());
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
