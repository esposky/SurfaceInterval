package com.example.otherjavafiles;

import java.io.Serializable;

public class UserInfo implements Serializable {
    // Info for the user table
    private int userId;
    private String userName;
    private String email;
    private String password;

    // Constructor
    public UserInfo(int userId,String userName, String email, String password) {
        this.userName = userName;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    // To String to print

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    // Getters and setters

    public String getUserName() { return userName;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
