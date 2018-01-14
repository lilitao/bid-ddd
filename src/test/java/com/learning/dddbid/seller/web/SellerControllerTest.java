package com.learning.dddbid.seller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.dddbid.ControllerTest;
import com.learning.dddbid.seller.application.SellerService;
import com.learning.dddbid.seller.domain.exception.InvalidPasswordException;
import com.learning.dddbid.seller.domain.model.Seller;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SellerControllerTest extends ControllerTest {
    @MockBean
    private SellerService sellerService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void should_register_ok_when_given_username_and_password() throws Exception {
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "123456";
        SellRegisterInputModel inputModel = new SellRegisterInputModel(email, userName, password);
        when(sellerService.register(anyString(), anyString(), anyString())).thenReturn(new Seller(email, userName, password));

        mockMvc.perform(post("/seller/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputModel))
        ).andExpect(status().isOk());
    }

    @Test
    public void should_fail_when_given_password_is_less_than_6_characters() throws Exception {
        String email = "abcd@gmail.com";
        String userName = "abcd";
        String password = "1234";
        SellRegisterInputModel inputModel = new SellRegisterInputModel(email, userName, password);
        when(sellerService.register(anyString(), anyString(), anyString())).thenThrow(InvalidPasswordException.class);

        mockMvc.perform(post("/seller/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputModel))
        ).andExpect(status().isBadRequest());
    }
}