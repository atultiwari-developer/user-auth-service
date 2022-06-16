package com.covid.userauthservice.service;

import com.covid.userauthservice.model.JwtTokenResponse;
import com.covid.userauthservice.model.UserData;
import com.covid.userauthservice.model.UserLoginDetails;

public interface UserAuthService {
    public int addUser(UserData userData) throws Exception;
    public JwtTokenResponse getToken(UserLoginDetails userLoginDetails) throws Exception;
}
