package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.models.User;
import com.samp.airways.models.UserDetail;
import com.samp.airways.requests.UserCreationRequest;
import com.samp.airways.requests.UserLoginRequest;
import com.samp.airways.requests.VerifyTokenRequest;
import com.samp.airways.response.Response;
import com.samp.airways.services.UserAuthenticationService;
import com.samp.airways.services.UserDetailService;
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
    private UserService user_service;

    @Autowired
    private UserDetailService user_detail_service;

    @Autowired
    private UserAuthenticationService user_authentication_service;
    
    @Autowired
    private Response res;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginRequest user_login_request) {
        Map<String, Object> data = new HashMap<>();
        
        try{
            User user = user_authentication_service.login(user_login_request);
            data.put("access_key", user_authentication_service.generateAccessKey(user));
            data.put("refresh_key", user_authentication_service.generateRefreshKey(user));
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody UserCreationRequest user_creation_request) {
        Map<String, Object> data = new HashMap<>();
        try{

            User user = user_service.saveUser(user_creation_request);
            user_detail_service.saveUserDetail(user, user_creation_request);
            String access_token = user_authentication_service.generateAccessKey(user);
            String refresh_token = user_authentication_service.generateRefreshKey(user);
            data.put("access_key", access_token);
            data.put("refresh_key", refresh_token);
            user_authentication_service.saveToken(user, access_token, refresh_token);
            return res.get(data, HttpStatus.CREATED);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/verify-token")
    public ResponseEntity<Object> verifyToken(@RequestBody VerifyTokenRequest token) {
        Map<String, Object> data = new HashMap<>();
        try{
            user_authentication_service.verifyToken(token);
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
