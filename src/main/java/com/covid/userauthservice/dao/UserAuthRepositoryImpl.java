package com.covid.userauthservice.dao;

import com.covid.userauthservice.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthRepositoryImpl implements UserAuthRepository{

    final String USER_INSERT_QUERY = "insert into covid_app_tracker_data.user_data (FirstName, LastName,email,password,isActive) values (?, ?,?,?,?)";
    final String USER_DATA_QUERY = "SELECT * FROM covid_app_tracker_data.user_data WHERE email = ? and password = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int addUser(UserData userData) throws Exception {
        Object[]args = {userData.getFirstName(),userData.getLastName(),userData.getEmail(),userData.getPassword(),userData.isActive()};
        int row = jdbcTemplate.update(USER_INSERT_QUERY,args);
        return row;
    }

    @Override
    public UserData getUserDetail(String userName, String encodePassword) throws Exception {
        return  (UserData) jdbcTemplate.queryForObject(
                USER_DATA_QUERY,
                new Object[]{userName,encodePassword},
                new BeanPropertyRowMapper(UserData.class));
    }
}
