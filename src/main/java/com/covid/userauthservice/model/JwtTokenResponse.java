package com.covid.userauthservice.model;

public class JwtTokenResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtTokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
