package com.mariworld.accountdemo.user.controller;

import com.mariworld.accountdemo.user.dto.UserDTO;
import com.mariworld.accountdemo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> signin(@RequestBody UserDTO userDTO){
        userService.signin(userDTO);
    }
}
