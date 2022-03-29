package com.samp.airways.services;

import java.util.Optional;

import com.samp.airways.models.User;

public interface UserAuthenticationService {

    Optional<String> login(String email, String password);
  
    Optional<User> findByToken(String token);
  
    void logout(User user);
  }