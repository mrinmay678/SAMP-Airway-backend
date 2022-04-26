package com.samp.airways.requests;

import java.sql.Date;

import lombok.Data;

@Data
public class UserCreationRequest {
    public String email;
    public String password;
    public String first_name;
    public String last_name;
    public String country_code;
    public String phone_number;
    public String profile_pic;
    public Date dob;
}


