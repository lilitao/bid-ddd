package com.learning.dddbid.seller;

import com.learning.dddbid.seller.application.SellerRepository;
import com.learning.dddbid.seller.application.SellerService;
import com.learning.dddbid.seller.domain.exception.InvalidPasswordException;
import com.learning.dddbid.seller.infrastructure.EmailNotifyService;
import com.learning.dddbid.seller.repository.spring.SellerSpringRepository;
import com.learning.dddbid.seller.repository.SellerJpaRepository;
import com.learning.dddbid.seller.repository.entity.SellerEntity;
import com.learning.dddbid.seller.web.SellerController;
import com.learning.dddbid.seller.web.SellRegisterInputModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SellerRegisterTest.SellerRegisterTestConfiguration.class})
public class SellerRegisterTest {
    @Autowired
    private SellerController sellerController;

    @Autowired
    private SellerSpringRepository repository;

    @Autowired
    private EmailNotifyService emailNotifyService;

    @Test
    public void should_register_seller() throws Exception {
        //Given
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "123456";
        SellRegisterInputModel sellerInput = new SellRegisterInputModel(email, userName, password);
        when(repository.save(any(SellerEntity.class))).thenReturn(new SellerEntity(email, userName, password));

        //When
        String result = sellerController.register(sellerInput);

        //Then
        assertEquals(email, result);
    }

    @Test(expected = InvalidPasswordException.class)
    public void should_fail_when_password_length_is_less_than_6() throws Exception {
        //Given
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "1234";
        SellRegisterInputModel sellerInput = new SellRegisterInputModel(email, userName, password);

        //When
        sellerController.register(sellerInput);
    }

    @Test
    public void should_receive_email_notification_when_registered_successfully() throws Exception {
        //Given
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "123456";
        SellRegisterInputModel sellerInput = new SellRegisterInputModel(email, userName, password);
        when(repository.save(any(SellerEntity.class))).thenReturn(new SellerEntity(email, userName, password));

        //When
        sellerController.register(sellerInput);

        //Then
        verify(emailNotifyService, times(1)).sendRegisteredEmail(email);
    }

    @Configuration
    public static class SellerRegisterTestConfiguration {
        @Bean
        public SellerController controller() {
            return new SellerController();
        }

        @Bean
        public SellerService sellerService() {
            return new SellerService();
        }

        @Bean
        public SellerRepository sellerRepository() {
            return new SellerJpaRepository();
        }

        @Bean
        public SellerSpringRepository sellerEntityRepository() {
            return mock(SellerSpringRepository.class);
        }

        @Bean
        public EmailNotifyService emailNotifyService() {
            return mock(EmailNotifyService.class);
        }
    }
}

