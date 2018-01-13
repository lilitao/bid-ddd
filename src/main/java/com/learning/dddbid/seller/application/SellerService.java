package com.learning.dddbid.seller.application;

import com.learning.dddbid.seller.domain.model.Seller;
import com.learning.dddbid.seller.repository.SellerRepository;
import org.springframework.stereotype.Component;

@Component
public class SellerService {
    private SellerRepository repository;

    public SellerService(SellerRepository repository) {

        this.repository = repository;
    }

    public Seller register(String email, String userName, String password) {
        Seller seller = new Seller(email, userName, password);

        return repository.save(seller);
    }
}
