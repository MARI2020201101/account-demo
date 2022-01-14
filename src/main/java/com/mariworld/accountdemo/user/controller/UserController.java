package com.mariworld.accountdemo.user.controller;

import com.mariworld.accountdemo.user.model.dto.UserRequest;
import com.mariworld.accountdemo.user.model.dto.UserResponse;
import com.mariworld.accountdemo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/user/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> signin(@RequestBody UserRequest userRequest){
        UserResponse signin = userService.signin(userRequest);
        return new ResponseEntity<>(signin , HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserRequest userRequest){
        UserResponse signup = userService.signup(userRequest);
        return new ResponseEntity<>(signup , HttpStatus.OK);
    }

    @PostMapping("/signin/v2")
    public ResponseEntity<UserResponse> signinV2(@RequestBody UserRequest userRequest){
        UserResponse signin = userService.signinV2(userRequest);
        return new ResponseEntity<>(signin , HttpStatus.OK);
    }

    @PostMapping("/signup/v2")
    public ResponseEntity<UserResponse> signupV2(@RequestBody UserRequest userRequest){
        UserResponse signup = userService.signupV2(userRequest);
        return new ResponseEntity<>(signup , HttpStatus.OK);
    }
}
