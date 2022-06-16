package com.covid.userauthservice.service;

import com.covid.userauthservice.model.UserData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private Long jwtExpirationInMs;
    @Override
    public String generateToken(UserData userData) throws Exception {
        Date expiryDate = new Date(new Date().getTime() + this.jwtExpirationInMs);

        String jwtToken =  Jwts.builder()
                .setClaims(new HashMap<String, Object>())
                .setSubject(userData.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();
        return jwtToken;
    }
}
