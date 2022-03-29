package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.User;
import com.samp.airways.response.Response;
import com.samp.airways.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/auth")
public class AuthenticationController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private Response res;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>();
        
        try{
            // data.put("access_key", getAccessKey(params.getEmail()));
            // data.put("refresh_key", getRefreshKey(params.getEmail()));
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>();
        try{
            // data.put("access_key", getAccessKey(params.getEmail()));
            // data.put("refresh_key", getRefreshKey(params.getEmail()));
            return res.get(data, HttpStatus.CREATED);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
