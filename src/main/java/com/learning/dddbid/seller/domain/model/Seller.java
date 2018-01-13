package com.learning.dddbid.seller.domain.model;

import com.learning.dddbid.seller.domain.InvalidPasswordException;

public class Seller {
    private final String email;
    private final String userName;
    private final String password;

    public Seller(String email, String userName, String password) {
        validatePassword(password);

        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    protected void validatePassword(String password) {
        if (password == null || password.length() < 6) {
            throw new InvalidPasswordException("Password should has at least 6 characters.");
        }
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
