package com.samp.airways.services;

import javax.transaction.Transactional;

import com.samp.airways.models.User;
import com.samp.airways.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class UserService{

    @Autowired
    private UserRepository userRepo;

    public User  saveUser(User user){
        return userRepo.save(user);
    }
    public User  getUser(String email){
        return userRepo.findByEmail(email);
    }

}
