package com.samp.airways.services;

import java.util.Optional;

import com.samp.airways.models.User;
import com.samp.airways.repositories.UserRepository;
import com.samp.airways.requests.UserLoginRequest;
import com.samp.airways.requests.VerifyTokenRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UserAuthenticationService {

  @Autowired
  private UserRepository user_repository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public String generateAccessKey(User user) {
    String username = user.getUsername();
    return null;
  }
  public String generateRefreshKey(User user) {
    String username = user.getUsername();
    return null;
  }
  public User login(UserLoginRequest user_login_request) {
    Optional<User> byEmail = user_repository.findByEmail(user_login_request.email);
    if (byEmail.isPresent()) {
      throw new RuntimeException("User not found");
    }
    if(passwordEncoder.matches(user_login_request.password, byEmail.get().getPassword())){
      return byEmail.get();
    }
    else {
      throw new Exception("Invalid Credentials");
    }
  }
  public void verifyToken(VerifyTokenRequest token) {

  }
  public void saveToken(User user, String access_token, String refresh_token) {
    
  }
}