package com.covid.userauthservice.service;

import com.covid.userauthservice.model.UserData;

public interface JwtTokenService {
public String generateToken(UserData userData) throws Exception;
}
