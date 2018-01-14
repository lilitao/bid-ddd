package com.learning.dddbid.seller.application;

import com.learning.dddbid.infrastructure.EmailNotifyService;
import com.learning.dddbid.seller.domain.exception.InvalidPasswordException;
import com.learning.dddbid.seller.domain.model.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SellerServiceTest {
    @Mock
    private SellerRepository repository;
    @Mock
    private EmailNotifyService emailNotifyService;

    SellerService service;

    @Test
    public void should_register_seller() throws Exception {
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "123456";
        service = new SellerService(repository, emailNotifyService);
        when(repository.save(any(Seller.class))).thenReturn(new Seller(email, userName, password));

        Seller seller = service.register(email, userName, password);

        assertEquals(email, seller.getEmail());
    }

    @Test(expected = InvalidPasswordException.class)
    public void should_fail_when_password_length_is_less_than_6() throws Exception {
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "1234";
        service = new SellerService(repository, emailNotifyService);

        service.register(email, userName, password);
    }
}