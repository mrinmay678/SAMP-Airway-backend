package com.samp.airways.services;

import javax.transaction.Transactional;

import com.samp.airways.models.User;
import com.samp.airways.models.UserDetail;
import com.samp.airways.repositories.UserDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepo;

    public UserDetail getUserDetail(User user) {
        return userDetailRepo.findByUserid(user.getId());
    }

    public UserDetail saveUserDetail(UserDetail userDetail) {
        return userDetailRepo.save(userDetail);
    }
    
}
