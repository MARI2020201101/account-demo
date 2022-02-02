package com.mariworld.accountdemo.user.service;

import com.mariworld.accountdemo.user.model.dto.UserRequest;
import com.mariworld.accountdemo.user.model.dto.UserResponse;

public interface UserService {
    UserResponse signin(UserRequest userRequest);
    UserResponse signup(UserRequest userRequest);


}
