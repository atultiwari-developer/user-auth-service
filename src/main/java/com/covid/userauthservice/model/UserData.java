package com.covid.userauthservice.model;

import java.util.Objects;

public class UserData {
    private int userid;
    private String firstName;
    private String lastName;
    private String email;

    private String password;
    private boolean isActive;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return userid == userData.userid && isActive == userData.isActive && firstName.equals(userData.firstName) && lastName.equals(userData.lastName) && email.equals(userData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, firstName, lastName, email, isActive);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userid=" + userid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
