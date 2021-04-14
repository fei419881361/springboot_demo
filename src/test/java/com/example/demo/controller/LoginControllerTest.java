package com.example.demo.controller;

import com.example.demo.request.PasswordLoginRequest;
import com.example.demo.response.BaseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
    @Autowired
    LoginController loginController;

    @Test
    public void testPasswordLogin() {
        PasswordLoginRequest request = new PasswordLoginRequest();
        request.setEmail("zlf");
        request.setPassword("zlf");
        BaseResponse response = loginController.passwordLogin(request);
        System.out.println(response);
    }

}