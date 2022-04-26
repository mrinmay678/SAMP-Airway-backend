package com.samp.airways.controllers;

import java.util.HashMap;
import java.util.Map;

import com.samp.airways.requests.JwtRequest;
import com.samp.airways.response.Response;
import com.samp.airways.services.UserService;
import com.samp.airways.utility.JWTUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    
    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody JwtRequest jwtRequest) {

        Response res = new Response();
        try {
            Map<String, Object> data = new HashMap<>();
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                jwtRequest.getUsername(),
                                jwtRequest.getPassword()
                        )
                );
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
    
            final UserDetails userDetails
                    = userService.loadUserByUsername(jwtRequest.getUsername());
    
            final String token =
                    jwtUtility.generateToken(userDetails);
            data.put("access_token", token);
            return res.get(data, HttpStatus.OK);
        }
        catch(Exception e){
            return res.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
