package com.covid.userauthservice.service;

import com.covid.userauthservice.dao.UserAuthRepository;
import com.covid.userauthservice.model.JwtTokenResponse;
import com.covid.userauthservice.model.UserData;
import com.covid.userauthservice.model.UserLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public int addUser(UserData userData) throws Exception {
        String encodedString = getEncodedPass(userData.getPassword());
        userData.setPassword(encodedString);

        return userAuthRepository.addUser(userData);
    }

    @Override
    public JwtTokenResponse getToken(UserLoginDetails userLoginDetails) throws Exception {
        JwtTokenResponse jwtTokenResponse = new JwtTokenResponse();
        UserData userData = getUserData(userLoginDetails);
        String token = jwtTokenService.generateToken(userData);
        jwtTokenResponse.setToken(token);
        System.out.println(userData.toString());
        return jwtTokenResponse;
    }

    private String getEncodedPass(String passwordStr){

 /*       Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(encodedString);
        System.out.println(new String(bytes));
*/
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedpass = encoder.encodeToString(passwordStr.getBytes());
        return encodedpass;

    }

    private UserData getUserData(UserLoginDetails userLoginDetails) throws Exception{
           String encodePassword = getEncodedPass(userLoginDetails.getPassword());
            UserData userData   = userAuthRepository.getUserDetail(userLoginDetails.getUserName(),encodePassword);
            return userData;
    }
}
