package com.mariworld.accountdemo.service;

import com.mariworld.accountdemo.user.model.dto.UserRequest;
import com.mariworld.accountdemo.user.model.dto.UserResponse;
import com.mariworld.accountdemo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void signupTest(){
        UserRequest user01 = UserRequest.builder().id("user01").pwd("1111").build();
        log.warn("UserRequest {}", user01);
        UserResponse userResponse = userService.signup(user01);
        log.warn("userResponse {}", userResponse);
    }
}
