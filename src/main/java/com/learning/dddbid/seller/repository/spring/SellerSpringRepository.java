package com.learning.dddbid.seller.repository.spring;

import com.learning.dddbid.seller.repository.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerSpringRepository extends CrudRepository<SellerEntity, String>{

}
