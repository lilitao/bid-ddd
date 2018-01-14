package com.learning.dddbid.seller.web;

public class SellRegisterInputModel {
    private String email;
    private String userName;
    private String password;

    public SellRegisterInputModel() {
    }

    public SellRegisterInputModel(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
