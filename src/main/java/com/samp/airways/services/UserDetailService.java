package com.samp.airways.services;

import javax.transaction.Transactional;

import com.samp.airways.models.AppUser;
import com.samp.airways.models.UserDetail;
import com.samp.airways.repositories.UserDetailRepository;
import com.samp.airways.requests.UserCreationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepo;


    public UserDetail getUserDetail(AppUser user) {
        return userDetailRepo.findByUserid(user.getId());
    }

    public UserDetail saveUserDetail(AppUser user, UserCreationRequest user_creation_request) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserid(user);
        userDetail.setFirst_name((String) user_creation_request.first_name);
        userDetail.setLast_name(user_creation_request.last_name);
        userDetail.setCountry_code(user_creation_request.country_code);
        userDetail.setPhone_number(user_creation_request.phone_number);
        userDetail.setProfile_pic(user_creation_request.profile_pic);
        userDetail.setDob(user_creation_request.dob);
        return userDetailRepo.save(userDetail);
    }
    
}
