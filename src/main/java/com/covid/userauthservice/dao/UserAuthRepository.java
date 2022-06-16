package com.covid.userauthservice.dao;

import com.covid.userauthservice.model.UserData;

public interface UserAuthRepository {
    public int addUser(UserData userData) throws Exception;

    UserData getUserDetail(String userName, String encodePassword) throws Exception;
}
