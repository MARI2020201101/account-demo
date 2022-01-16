package com.mariworld.accountdemo.user.controller;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.CustomResponseEntity;
import com.mariworld.accountdemo.user.model.dto.UserRequest;
import com.mariworld.accountdemo.user.model.dto.UserResponse;
import com.mariworld.accountdemo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/user/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/welcome")
    public CustomResponseEntity<String> welcome(String name){
        return new CustomResponseEntity<>(String.format("welcome --** %s **--", name), CustomCode.SUCCESS);
    }

    @PostMapping("/signin")
    public CustomResponseEntity<UserResponse> signin(@RequestBody UserRequest userRequest){
        UserResponse signin = userService.signin(userRequest);
        return new CustomResponseEntity<>(signin, CustomCode.SUCCESS);
    }

    @PostMapping("/signup")
    public CustomResponseEntity<UserResponse> signup(@RequestBody UserRequest userRequest){
        UserResponse signup = userService.signup(userRequest);
        return new CustomResponseEntity<>(signup , CustomCode.SUCCESS);
    }

}
