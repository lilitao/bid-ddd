package com.learning.dddbid.seller.repository;

import com.learning.dddbid.seller.application.SellerRepository;
import com.learning.dddbid.seller.domain.model.Seller;
import com.learning.dddbid.seller.repository.entity.SellerEntity;
import com.learning.dddbid.seller.repository.spring.SellerSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellerJpaRepository implements SellerRepository {
    @Autowired
    private SellerSpringRepository repository;

    public SellerJpaRepository() {
    }

    @Override
    public Seller save(Seller seller) {
        return repository.save(new SellerEntity(seller)).toSeller();
    }
}
