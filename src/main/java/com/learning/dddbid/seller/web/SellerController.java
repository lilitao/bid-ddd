package com.learning.dddbid.seller.web;

import com.learning.dddbid.seller.application.SellerService;
import com.learning.dddbid.seller.domain.exception.InvalidPasswordException;
import com.learning.dddbid.seller.domain.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/seller/register")
    public String register(@RequestBody SellRegisterInputModel sellerInputModel) {
        Seller seller = sellerService.register(sellerInputModel.getEmail(), sellerInputModel.getUserName(), sellerInputModel.getPassword());

        return seller.getEmail();
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidPasswordHandler(InvalidPasswordException ex) {

    }
}
