package com.learning.dddbid.seller.application;

import com.learning.dddbid.seller.domain.model.Seller;

public interface SellerRepository {
    Seller save(Seller seller);
}
