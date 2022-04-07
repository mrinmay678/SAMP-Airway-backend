package com.samp.airways.services;

import javax.transaction.Transactional;

import com.samp.airways.models.User;
import com.samp.airways.repositories.UserRepository;
import com.samp.airways.requests.UserCreationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service @Transactional
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(UserCreationRequest user_creation_request) {
        User user = new User();
        String email = user_creation_request.email;
        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            throw new RuntimeException("Email already registered. Please use different email.");
        }
        String[] split = email.split("@", 2);
        user.setEmail(email);
        user.setUsername(split[0]);
        user.setPassword(passwordEncoder.encode(user_creation_request.password));
        userRepository.save(user);
        return user;
    }
    public String getUsername(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            return byEmail.get().getUsername();
        }
        throw new EntityNotFoundException("User not found");
    }

    public Optional<User> getUser(String email){
        return userRepository.findByEmail(email);
    }

}
