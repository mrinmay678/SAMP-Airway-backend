package com.samp.airways.repositories;

import com.samp.airways.models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByUserid(Long userid);
}
