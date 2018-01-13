package com.learning.dddbid.seller.web;

import com.learning.dddbid.seller.application.SellerService;
import com.learning.dddbid.seller.domain.model.Seller;
import com.learning.dddbid.web.ControllerTest;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SellerControllerTest extends ControllerTest {
    @MockBean
    private SellerService sellerService;

    @Test
    public void should_register_ok_when_given_username_and_password() throws Exception {
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "123456";
        when(sellerService.register(anyString(), anyString(), anyString())).thenReturn(new Seller(email, userName, password));

        long id = 1L;
        mockMvc.perform(post("/seller/register")
                .param("email", email)
                .param("userName", userName)
                .param("password", password)
        ).andExpect(status().isOk())
                .andExpect(content().string(email));
    }
}