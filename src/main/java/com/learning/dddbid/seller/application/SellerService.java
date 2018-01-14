package com.learning.dddbid.seller.application;

import com.learning.dddbid.seller.domain.model.Seller;
import com.learning.dddbid.infrastructure.EmailNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerService {
    public SellerService() {
    }

    @Autowired
    private SellerRepository repository;

    @Autowired
    private EmailNotifyService emailNotifyService;

    public SellerService(SellerRepository repository, EmailNotifyService emailNotifyService) {
        this.repository = repository;
        this.emailNotifyService = emailNotifyService;
    }

    public Seller register(String email, String userName, String password) {
        Seller seller = new Seller(email, userName, password);

        Seller result = repository.save(seller);
        emailNotifyService.sendRegisteredEmail(result.getEmail());
        return result;
    }
}
