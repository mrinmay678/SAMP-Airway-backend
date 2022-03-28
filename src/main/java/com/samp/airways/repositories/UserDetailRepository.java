package com.samp.airways.repositories;

import com.samp.airways.models.User;
import com.samp.airways.models.UserDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByUserid(Long userid);
}
