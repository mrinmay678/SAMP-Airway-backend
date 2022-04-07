package com.samp.airways.requests;

import lombok.Data;

@Data
public class UserLoginRequest {
    public String email;
    public String password;
}
