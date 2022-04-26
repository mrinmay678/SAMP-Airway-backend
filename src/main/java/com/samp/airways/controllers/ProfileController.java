package com.samp.airways.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.AppUser;
import com.samp.airways.models.UserDetail;
import com.samp.airways.response.Response;
import com.samp.airways.services.UserDetailService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.POST})
public class ProfileController {
    
    @Autowired
    private UserDetailService userDetailService;
    
    @GetMapping("/profile")
    public ResponseEntity<Object> profile() {
        Response res = new Response();
        
        try{
            Map<String, Object> data = new HashMap<>();
            // User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // AppUser appUser = userDetailService.getUser(user.getUsername());
            // UserDetail ud = userDetailService.getUserDetail(user);
            // data.put("first_name", ud.getFirst_name());
            // data.put("last_name", ud.getLast_name());
            // data.put("dob", ud.getDob());
            // data.put("country_code", ud.getCountry_code());
            // data.put("phone_number", ud.getPhone_number());
            // data.put("email", user.getEmail());
            // data.put("tickets", ud.getBookings());
            data.put("first_name", "Admin");
            data.put("last_name", "User");
            data.put("dob", "20th April, 1995");
            data.put("country_code", "+91");
            data.put("phone_number", "9876543210");
            data.put("email", "admin@samp.com");
            data.put("tickets", new ArrayList<>());
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
