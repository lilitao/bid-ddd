package com.learning.dddbid.web;

import com.learning.dddbid.DddBidApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DddBidApplication.class)
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class ApiTest {
    @Test
    public void just_a_placeholder() throws Exception {
        assertTrue(true);
    }
}
