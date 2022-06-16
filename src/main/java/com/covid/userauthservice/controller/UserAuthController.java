package com.covid.userauthservice.controller;

import com.covid.userauthservice.model.JwtTokenResponse;
import com.covid.userauthservice.model.UserData;
import com.covid.userauthservice.model.UserLoginDetails;
import com.covid.userauthservice.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/covid")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;
    @GetMapping("/user")
    public String check(){
        return "it is working";
    }
    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserData userData){
     int row = 0;
        try{
           row =  userAuthService.addUser(userData);
        }catch(Exception ex){
            return new ResponseEntity<>(row, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(row, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> getToken(@RequestBody UserLoginDetails userLoginDetails){
        JwtTokenResponse jwtTokenResponse = null;
        try{
            jwtTokenResponse =  userAuthService.getToken(userLoginDetails);
        }catch(Exception ex){
            return new ResponseEntity<>(jwtTokenResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jwtTokenResponse, HttpStatus.OK);
    }

}
