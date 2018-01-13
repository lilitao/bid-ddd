package com.learning.dddbid.seller.web;

import com.learning.dddbid.seller.application.SellerService;
import com.learning.dddbid.seller.domain.model.Seller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    private SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/seller/register")
    public String register(String email, String userName, String password) {
        Seller seller = sellerService.register(email, userName, password);

        return seller.getEmail();
    }
}
