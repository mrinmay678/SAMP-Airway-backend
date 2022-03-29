package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.User;
import com.samp.airways.models.UserDetail;
import com.samp.airways.response.Response;
import com.samp.airways.services.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ProfileController {
    
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private Response res;

    @RequestMapping("/profile")
    public ResponseEntity<Object> profile(@RequestParam User user) {
        try{
            Map<String, Object> data = new HashMap<>();
            UserDetail ud = userDetailService.getUserDetail(user);
            data.put("first_name", ud.getFirst_name());
            data.put("last_name", ud.getLast_name());
            data.put("dob", ud.getDob());
            data.put("country_code", ud.getCountry_code());
            data.put("phone_number", ud.getPhone_number());
            data.put("email", user.getEmail());
            data.put("tickets", ud.getBookings());
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
