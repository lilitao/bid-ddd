package com.learning.dddbid.seller.repository;

import com.learning.dddbid.JpaTest;
import com.learning.dddbid.seller.domain.model.Seller;
import com.learning.dddbid.seller.repository.entity.SellerEntity;
import com.learning.dddbid.seller.repository.spring.SellerSpringRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class SellerRepositoryTest extends JpaTest{
    @Autowired
    private SellerSpringRepository repository;

    @Test
    public void should_save_seller() throws Exception {
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "123456";

        Seller seller = repository.save(new SellerEntity(email, userName, password)).toSeller();

        assertEquals(email, seller.getEmail());
    }
}