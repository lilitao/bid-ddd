package com.learning.dddbid.seller.domain.model;

public class Seller {
    private final String email;
    private final String userName;
    private final String password;

    public Seller(String email, String userName, String password) {

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
